package pl.edu.agh.server;

import CurrencyModule.generated.protoc.Currencies;
import CurrencyModule.generated.protoc.Currency;
import CurrencyModule.generated.protoc.ExchangeRate;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import pl.edu.agh.impl.BankSessionFactoryImpl;
import pl.edu.agh.impl.CurrenciesModel;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static CurrencyModule.generated.protoc.CurrenciesStreamGrpc.newBlockingStub;
import static com.zeroc.Ice.Util.stringToIdentity;

@Slf4j
public class Server {

    Server() {
    }

    private static Map<String, Float> supportedCurrenciesWithValues = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            Server server = new Server();
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(args[1]));
            CurrenciesModel currenciesModel = gson.fromJson(reader, CurrenciesModel.class);
            new Thread(() -> server.subscribeCurrenciesService("localhost", 50051, currenciesModel.getSupportedCurrencies())).start();
            new Thread(() -> server.runIce(args)).start();
        } catch (Exception e) {
            log.error("EXCEPTION OCCURED");
            log.error(e.getMessage());
        }
    }


    public static Map<String, Float> getSupportedCurrenciesWithValues() {
        return supportedCurrenciesWithValues;
    }

    public static float getRateForCurrency(String currency) {
        return supportedCurrenciesWithValues.get(currency);
    }

    public void addExchangeRate(String currency, Float currentRate) {
        supportedCurrenciesWithValues.put(currency, currentRate);
    }

    public void shutdown(ManagedChannel channel) throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private void runIce(String[] args) {
        try (com.zeroc.Ice.Communicator communicator = Util.initialize(args, "config.server")) {
            log.info("Initialized communicator");
            ObjectAdapter adapter = communicator.createObjectAdapter(args[0]);
            adapter.add(new BankSessionFactoryImpl(), stringToIdentity("BankSessionFactory"));
            adapter.activate();
            log.info("adapter activated, waiting for shutdown");
            communicator.waitForShutdown();
        }
    }

    public void subscribeCurrenciesService(String host, int port, List<String> supportedCurrencies) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        log.info("channel builded succesfully");
        Iterator<ExchangeRate> exchangeRates = newBlockingStub(channel)
                .getCurrenciesRate(Currencies.newBuilder()
                        .addAllCurrencies(Arrays.stream(Currency.values()).filter(currency -> supportedCurrencies.contains(currency.name())).collect(Collectors.toList()))
                        .build());
        log.info("exchange rates subscribed");
        try {
            while (exchangeRates.hasNext()) {
                ExchangeRate exchangeRate = exchangeRates.next();
                log.info("received exchange rate for value: " + exchangeRate.getCurrency().name() + ", is: " + exchangeRate.getRate());
                addExchangeRate(exchangeRate.getCurrency().name(), exchangeRate.getRate());
            }
            channel.shutdown();
        } catch (StatusRuntimeException ex) {
            log.error(ex.getMessage());
            channel.shutdown();
        }
    }
}
