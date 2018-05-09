package pl.edu.agh.impl;

import BankModule.AccountPrx;
import BankModule.BankSession;
import BankModule.RegisterResponse;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class BankSessionImpl implements BankSession {
    final private String name;
    private List<AccountPrx> accounts = new LinkedList<>();

    BankSessionImpl(String name) {
        this.name = name;
    }

    @Override
    public RegisterResponse createAccount(String fullName, String idNumber, int declaredIncome, Current current) {
        log.info("New client joined!" + "Name: " + fullName + "Income: " + declaredIncome + "Id: " + idNumber);
        AccountPrx obj;
        String uuid = UUID.randomUUID().toString();
        if (declaredIncome > 15000) {
            obj = AccountPrx.uncheckedCast(current.adapter.add(new PremiumAccountImpl(fullName, declaredIncome, uuid), new Identity(idNumber, "premium")));
            log.info("premium account created");
        } else {
            obj = AccountPrx.uncheckedCast(current.adapter.add(new AccountImpl(fullName, declaredIncome, uuid), new Identity(idNumber, "regular")));
            log.info("regular account created");
        }
        accounts.add(obj);
        return new RegisterResponse(obj, uuid);
    }

    @Override
    public void removeAccount(String idNumber, Current current) {
    }

    @Override
    public String getName(Current current) {
        return name;
    }
}
