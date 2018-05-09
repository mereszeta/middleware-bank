package pl.edu.agh.impl;

import BankModule.BankSessionFactory;
import BankModule.BankSessionPrx;
import com.zeroc.Ice.Current;

import static BankModule.BankSessionPrx.*;

public class BankSessionFactoryImpl implements BankSessionFactory {
    @Override
    public BankSessionPrx create(String sessionName, Current current) {
        BankSessionImpl bankSession = new BankSessionImpl(sessionName);
        return uncheckedCast(current.adapter.addWithUUID(bankSession));
    }
}
