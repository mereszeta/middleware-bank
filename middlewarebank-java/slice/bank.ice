#ifndef BANK_ICE
#define BANK_ICE
module BankModule{

exception InvalidTokenException{};
exception CurrencyNotSupportedException{};
sequence <string> supportedCurrencies;
enum accountType{
REGULAR,PREMIUM
};
class LoanResponse{
    double costInLocalCurrency;
    double costInGivenCurrency;
};

interface Account{
    double checkAccountBalance(string sessionToken) throws InvalidTokenException;
};
class RegisterResponse{
    Account* account;
    string token;
};
interface PremiumAccount extends Account{
    supportedCurrencies getSupportedCurrencies(string sessionToken) throws InvalidTokenException;
    LoanResponse getLoanInformation(string sessionToken,string currency,int amount) throws InvalidTokenException,CurrencyNotSupportedException;
};
interface BankSession{
    RegisterResponse createAccount(string fullName, string idNumber,int declaredIncome);
    void removeAccount(string idNumber);
    idempotent string getName();
};
interface BankSessionFactory {
    BankSession* create(string sessionName);
 };
};

#endif