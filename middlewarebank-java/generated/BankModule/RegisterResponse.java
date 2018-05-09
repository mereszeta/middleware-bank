// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package BankModule;

public class RegisterResponse extends com.zeroc.Ice.Value
{
    public RegisterResponse()
    {
        this.token = "";
    }

    public RegisterResponse(AccountPrx account, String token)
    {
        this.account = account;
        this.token = token;
    }

    public AccountPrx account;

    public String token;

    public RegisterResponse clone()
    {
        return (RegisterResponse)super.clone();
    }

    public static String ice_staticId()
    {
        return "::BankModule::RegisterResponse";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    public static final long serialVersionUID = -2890403014013790243L;

    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, true);
        ostr_.writeProxy(account);
        ostr_.writeString(token);
        ostr_.endSlice();
    }

    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        account = AccountPrx.uncheckedCast(istr_.readProxy());
        token = istr_.readString();
        istr_.endSlice();
    }
}
