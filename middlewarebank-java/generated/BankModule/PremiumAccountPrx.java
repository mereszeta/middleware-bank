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

public interface PremiumAccountPrx extends AccountPrx
{
    default String[] getSupportedCurrencies(String sessionToken)
        throws InvalidTokenException
    {
        return getSupportedCurrencies(sessionToken, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default String[] getSupportedCurrencies(String sessionToken, java.util.Map<String, String> context)
        throws InvalidTokenException
    {
        try
        {
            return _iceI_getSupportedCurrenciesAsync(sessionToken, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidTokenException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<String[]> getSupportedCurrenciesAsync(String sessionToken)
    {
        return _iceI_getSupportedCurrenciesAsync(sessionToken, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<String[]> getSupportedCurrenciesAsync(String sessionToken, java.util.Map<String, String> context)
    {
        return _iceI_getSupportedCurrenciesAsync(sessionToken, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<String[]> _iceI_getSupportedCurrenciesAsync(String iceP_sessionToken, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<String[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSupportedCurrencies", null, sync, _iceE_getSupportedCurrencies);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_sessionToken);
                 }, istr -> {
                     String[] ret;
                     ret = istr.readStringSeq();
                     return ret;
                 });
        return f;
    }

    static final Class<?>[] _iceE_getSupportedCurrencies =
    {
        InvalidTokenException.class
    };

    default LoanResponse getLoanInformation(String sessionToken, String currency, int amount)
        throws CurrencyNotSupportedException,
               InvalidTokenException
    {
        return getLoanInformation(sessionToken, currency, amount, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default LoanResponse getLoanInformation(String sessionToken, String currency, int amount, java.util.Map<String, String> context)
        throws CurrencyNotSupportedException,
               InvalidTokenException
    {
        try
        {
            return _iceI_getLoanInformationAsync(sessionToken, currency, amount, context, true).waitForResponseOrUserEx();
        }
        catch(CurrencyNotSupportedException ex)
        {
            throw ex;
        }
        catch(InvalidTokenException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<LoanResponse> getLoanInformationAsync(String sessionToken, String currency, int amount)
    {
        return _iceI_getLoanInformationAsync(sessionToken, currency, amount, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<LoanResponse> getLoanInformationAsync(String sessionToken, String currency, int amount, java.util.Map<String, String> context)
    {
        return _iceI_getLoanInformationAsync(sessionToken, currency, amount, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<LoanResponse> _iceI_getLoanInformationAsync(String iceP_sessionToken, String iceP_currency, int iceP_amount, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<LoanResponse> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getLoanInformation", null, sync, _iceE_getLoanInformation);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_sessionToken);
                     ostr.writeString(iceP_currency);
                     ostr.writeInt(iceP_amount);
                 }, istr -> {
                     final com.zeroc.IceInternal.Holder<LoanResponse> ret = new com.zeroc.IceInternal.Holder<>();
                     istr.readValue(v -> ret.value = v, LoanResponse.class);
                     istr.readPendingValues();
                     return ret.value;
                 });
        return f;
    }

    static final Class<?>[] _iceE_getLoanInformation =
    {
        CurrencyNotSupportedException.class,
        InvalidTokenException.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static PremiumAccountPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static PremiumAccountPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static PremiumAccountPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static PremiumAccountPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static PremiumAccountPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static PremiumAccountPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, PremiumAccountPrx.class, _PremiumAccountPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default PremiumAccountPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (PremiumAccountPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default PremiumAccountPrx ice_adapterId(String newAdapterId)
    {
        return (PremiumAccountPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default PremiumAccountPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (PremiumAccountPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default PremiumAccountPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (PremiumAccountPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default PremiumAccountPrx ice_invocationTimeout(int newTimeout)
    {
        return (PremiumAccountPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default PremiumAccountPrx ice_connectionCached(boolean newCache)
    {
        return (PremiumAccountPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default PremiumAccountPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (PremiumAccountPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default PremiumAccountPrx ice_secure(boolean b)
    {
        return (PremiumAccountPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default PremiumAccountPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (PremiumAccountPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default PremiumAccountPrx ice_preferSecure(boolean b)
    {
        return (PremiumAccountPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default PremiumAccountPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (PremiumAccountPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default PremiumAccountPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (PremiumAccountPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default PremiumAccountPrx ice_collocationOptimized(boolean b)
    {
        return (PremiumAccountPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default PremiumAccountPrx ice_twoway()
    {
        return (PremiumAccountPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default PremiumAccountPrx ice_oneway()
    {
        return (PremiumAccountPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default PremiumAccountPrx ice_batchOneway()
    {
        return (PremiumAccountPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default PremiumAccountPrx ice_datagram()
    {
        return (PremiumAccountPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default PremiumAccountPrx ice_batchDatagram()
    {
        return (PremiumAccountPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default PremiumAccountPrx ice_compress(boolean co)
    {
        return (PremiumAccountPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default PremiumAccountPrx ice_timeout(int t)
    {
        return (PremiumAccountPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default PremiumAccountPrx ice_connectionId(String connectionId)
    {
        return (PremiumAccountPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default PremiumAccountPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (PremiumAccountPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::BankModule::PremiumAccount";
    }
}
