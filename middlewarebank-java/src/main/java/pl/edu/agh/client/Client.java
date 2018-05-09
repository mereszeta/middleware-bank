package pl.edu.agh.client;

import BankModule.*;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Client {
    private static Map<String, String> peselTokenMap = new TreeMap<>();
    private static Map<AccountPrx, String> tokenAccountMap = new HashMap<>();

    public Client() {
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run(args);

    }

    public void run(String[] args) {
        try (Communicator communicator = Util.initialize(args, "config.client")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BankSessionFactoryPrx bankSessionFactoryPrx = BankSessionFactoryPrx.uncheckedCast(communicator.propertyToProxy("SessionFactory.Proxy"));
            BankSessionPrx sessionPrx = bankSessionFactoryPrx.create("session");
            printInfo();
            String line;

            System.out.println("Type: register [name] [surname] [pesel] [declared income] to start using this app");
            while (!(line = bufferedReader.readLine()).startsWith("register")) {
                System.out.println("Type: register [name] [surname] [pesel] [declared income] to start using this app");
            }
            AccountPrx currentUser = registerUser(line, sessionPrx);
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    String[] input = line.split(" ");
                    if (input.length > 0)
                        switch (input[0]) {
                            case "register":
                                currentUser = registerUser(line, sessionPrx);
                                break;
                            case "switch":
                                currentUser = switchUser(input);
                                break;
                            case "check":
                                checkBalance(currentUser);
                                break;
                            case "loan":
                                getLoanInfo(input, currentUser);
                                break;
                            case "currencies":
                                getSupportedCurrencies(input, currentUser);
                                break;
                            default:
                                System.out.println("invalid input");
                                printInfo();
                                break;
                        }
                } catch (CurrencyNotSupportedException cne) {
                    System.out.println("This Currency is not supported by current bank");
                } catch (InvalidTokenException ite) {
                    System.out.println("Acces Denied!");
                } catch (NumberFormatException nfe) {
                    System.out.println("Remember that numeric values(such as declared income/loan amount should be numeric!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public AccountPrx registerUser(String line, BankSessionPrx bankSessionPrx) throws Exception {
        String[] input = line.split(" ");
        if (input.length == 5) {
            int declaredIncome = Integer.parseInt(input[4]);
            RegisterResponse registerResponse = bankSessionPrx.createAccount(input[1] + " " + input[2], input[3], declaredIncome);
            tokenAccountMap.put(registerResponse.account, registerResponse.token);
            peselTokenMap.put(input[3], registerResponse.token);
            return registerResponse.account;

        } else throw new Exception("Invalid argument!");
    }

    public AccountPrx switchUser(String[] input) throws Exception {
        String token = null;
        if (input.length > 1) {
            token = peselTokenMap.get(input[1]);
        }
        if (token != null) {
            String finalToken = token;
            return tokenAccountMap
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(finalToken))
                    .findFirst()
                    .orElseThrow(Exception::new)
                    .getKey();
        } else throw new Exception("Invalid pesel!");
    }

    public void checkBalance(AccountPrx currentUser) throws InvalidTokenException {
        double balance = currentUser.checkAccountBalance(tokenAccountMap.get(currentUser));
        System.out.println("Your current account balance is: " + balance);
    }

    public void getLoanInfo(String[] input, AccountPrx currentUser) throws InvalidTokenException, CurrencyNotSupportedException {
        if (currentUser.ice_getIdentity().category.equals("premium") && input.length == 3) {
            PremiumAccountPrx premiumAccountPrx = PremiumAccountPrx.checkedCast(currentUser);
            int amount = Integer.parseInt(input[2]);
            String token = tokenAccountMap.get(currentUser);
            LoanResponse loanResponse = premiumAccountPrx.getLoanInformation(token, input[1], amount);
            System.out.println(loanResponse.costInGivenCurrency + " " + loanResponse.costInLocalCurrency);
        } else {
            System.out.println("invalid input or user has regular account");
        }
    }

    public void getSupportedCurrencies(String[] input, AccountPrx currentUser) throws InvalidTokenException {
        if (currentUser.ice_getIdentity().category.equals("premium") && input.length == 1) {
            PremiumAccountPrx premiumAccountPrx = PremiumAccountPrx.checkedCast(currentUser);
            String token = tokenAccountMap.get(currentUser);
            String[] currencies = premiumAccountPrx.getSupportedCurrencies(token);
            System.out.println("Supported currencies: ");
            Arrays.stream(currencies).forEach(System.out::println);
        } else {
            System.out.println("invalid input or user has regular account");
        }
    }

    public void printInfo() {
        System.out.println("To register new user type: register [name] [surname] [pesel] [declared income]");
        System.out.println("Remember, all parameters are required in given order, Pesel and declared income are numeric values");
        System.out.println("After registering your current user will be switched to the new one");
        System.out.println("To switch user type: switch [pesel]; if given user doesn't exist you'll be informed and current user will be logged");
        System.out.println("To check your account balance type check");
        System.out.println("To get information about supported currencies type: currencies");
        System.out.println("To get information about loan costs type: loan [currency] [amount]");
        System.out.println("Note that two last options are available only for premium account users");
        System.out.println("If currency you requested is not supported by this bank(or simply given currency doesn't exist you will receive proper info");
        System.out.println("To display this message type: help");
    }
}
