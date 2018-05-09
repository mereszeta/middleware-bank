package pl.edu.agh.impl;

import BankModule.CurrencyNotSupportedException;
import BankModule.InvalidTokenException;
import BankModule.LoanResponse;
import BankModule.PremiumAccount;
import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;
import pl.edu.agh.server.Server;

import java.util.Arrays;

@Slf4j
public class PremiumAccountImpl implements PremiumAccount {
    private final String fullName;
    private final int declaredIncome;
    private final String token;

    public PremiumAccountImpl(String fullName, int declaredIncome, String token) {
        this.fullName = fullName;
        this.declaredIncome = declaredIncome;
        this.token = token;
    }

    public LoanResponse getLoanInformation(String sessionToken, String currency, int amount, Current current) throws InvalidTokenException, CurrencyNotSupportedException {
        if (sessionToken.equals(token)) {
            log.info("[PREM_ACC_SERVANT] request for loan cost received");
            if (Arrays.stream(getSupportedCurrencies(token, current)).anyMatch(curr -> curr.equals(currency))) {
                float rate = Server.getRateForCurrency(currency);
                log.info("[PREM_ACC_SERVANT]Rate for currency: " +currency+", is: "+rate );
                return new LoanResponse((amount * rate + ((1 - Math.random()) * amount)), (amount + ((1 - Math.random()) * amount)));
            } else {
                throw new CurrencyNotSupportedException();
            }
        } else {
            throw new InvalidTokenException();
        }
    }

    public double checkAccountBalance(String sessionToken, Current current) throws InvalidTokenException {
        if (sessionToken.equals(token)) {
            log.info("[PREM_ACC_SERVANT] request for account balance received");
            return declaredIncome * Math.random();
        } else {
            throw new InvalidTokenException();
        }
    }

    public String[] getSupportedCurrencies(String sessionToken, Current current) throws InvalidTokenException {
        if (sessionToken.equals(token)) {
            log.info("[PREM_ACC_SERVANT] request for supported currencies received");
            return Server.getSupportedCurrenciesWithValues().keySet().toArray(new String[0]);
        } else {
            throw new InvalidTokenException();
        }
    }
}
