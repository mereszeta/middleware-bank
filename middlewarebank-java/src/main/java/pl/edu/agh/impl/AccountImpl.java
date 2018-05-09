package pl.edu.agh.impl;

import BankModule.Account;
import BankModule.InvalidTokenException;
import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountImpl implements Account {
    private final String fullName;
    private final int declaredIncome;
    private final String token;

    public AccountImpl(String fullName, int declaredIncome, String token) {
        this.fullName = fullName;
        this.declaredIncome = declaredIncome;
        this.token = token;
    }

    public double checkAccountBalance(String sessionToken, Current current) throws InvalidTokenException {
        if (sessionToken.equals(token)) {
            log.info("[REGULAR_ACC_SERVANT] request for account balance!");
            return  declaredIncome * Math.random();
        } else {
            throw new InvalidTokenException();
        }
    }

}
