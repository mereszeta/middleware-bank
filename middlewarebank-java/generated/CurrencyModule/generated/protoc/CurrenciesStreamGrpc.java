package CurrencyModule.generated.protoc;

/*
import javax.annotation.Generated;
*/

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *//*
@Generated(
        value = "by gRPC proto compiler (version 1.13.0-SNAPSHOT)",
        comments = "Source: currencies.proto")*/
public final class CurrenciesStreamGrpc {

    private CurrenciesStreamGrpc() {
    }

    public static final String SERVICE_NAME = "curr.CurrenciesStream";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @java.lang.Deprecated // Use {@link #getGetCurrenciesRateMethod()} instead.
    public static final io.grpc.MethodDescriptor<Currencies,
            ExchangeRate> METHOD_GET_CURRENCIES_RATE = getGetCurrenciesRateMethodHelper();

    private static volatile io.grpc.MethodDescriptor<Currencies,
            ExchangeRate> getGetCurrenciesRateMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<Currencies,
            ExchangeRate> getGetCurrenciesRateMethod() {
        return getGetCurrenciesRateMethodHelper();
    }

    private static io.grpc.MethodDescriptor<Currencies,
            ExchangeRate> getGetCurrenciesRateMethodHelper() {
        io.grpc.MethodDescriptor<Currencies, ExchangeRate> getGetCurrenciesRateMethod;
        if ((getGetCurrenciesRateMethod = CurrenciesStreamGrpc.getGetCurrenciesRateMethod) == null) {
            synchronized (CurrenciesStreamGrpc.class) {
                if ((getGetCurrenciesRateMethod = CurrenciesStreamGrpc.getGetCurrenciesRateMethod) == null) {
                    CurrenciesStreamGrpc.getGetCurrenciesRateMethod = getGetCurrenciesRateMethod =
                            io.grpc.MethodDescriptor.<Currencies, ExchangeRate>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "curr.CurrenciesStream", "GetCurrenciesRate"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Currencies.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            ExchangeRate.getDefaultInstance()))
                                    .setSchemaDescriptor(new CurrenciesStreamMethodDescriptorSupplier("GetCurrenciesRate"))
                                    .build();
                }
            }
        }
        return getGetCurrenciesRateMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CurrenciesStreamStub newStub(io.grpc.Channel channel) {
        return new CurrenciesStreamStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CurrenciesStreamBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new CurrenciesStreamBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CurrenciesStreamFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new CurrenciesStreamFutureStub(channel);
    }

    /**
     */
    public static abstract class CurrenciesStreamImplBase implements io.grpc.BindableService {

        /**
         */
        public void getCurrenciesRate(Currencies request,
                                      io.grpc.stub.StreamObserver<ExchangeRate> responseObserver) {
            asyncUnimplementedUnaryCall(getGetCurrenciesRateMethodHelper(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getGetCurrenciesRateMethodHelper(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            Currencies,
                                            ExchangeRate>(
                                            this, METHODID_GET_CURRENCIES_RATE)))
                    .build();
        }
    }

    /**
     */
    public static final class CurrenciesStreamStub extends io.grpc.stub.AbstractStub<CurrenciesStreamStub> {
        private CurrenciesStreamStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CurrenciesStreamStub(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CurrenciesStreamStub build(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            return new CurrenciesStreamStub(channel, callOptions);
        }

        /**
         */
        public void getCurrenciesRate(Currencies request,
                                      io.grpc.stub.StreamObserver<ExchangeRate> responseObserver) {
            asyncServerStreamingCall(
                    getChannel().newCall(getGetCurrenciesRateMethodHelper(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class CurrenciesStreamBlockingStub extends io.grpc.stub.AbstractStub<CurrenciesStreamBlockingStub> {
        private CurrenciesStreamBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CurrenciesStreamBlockingStub(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CurrenciesStreamBlockingStub build(io.grpc.Channel channel,
                                                     io.grpc.CallOptions callOptions) {
            return new CurrenciesStreamBlockingStub(channel, callOptions);
        }

        /**
         */
        public java.util.Iterator<ExchangeRate> getCurrenciesRate(
                Currencies request) {
            return blockingServerStreamingCall(
                    getChannel(), getGetCurrenciesRateMethodHelper(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class CurrenciesStreamFutureStub extends io.grpc.stub.AbstractStub<CurrenciesStreamFutureStub> {
        private CurrenciesStreamFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CurrenciesStreamFutureStub(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CurrenciesStreamFutureStub build(io.grpc.Channel channel,
                                                   io.grpc.CallOptions callOptions) {
            return new CurrenciesStreamFutureStub(channel, callOptions);
        }
    }

    private static final int METHODID_GET_CURRENCIES_RATE = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final CurrenciesStreamImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(CurrenciesStreamImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_CURRENCIES_RATE:
                    serviceImpl.getCurrenciesRate((Currencies) request,
                            (io.grpc.stub.StreamObserver<ExchangeRate>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class CurrenciesStreamBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        CurrenciesStreamBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return CurrencyProto.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CurrenciesStream");
        }
    }

    private static final class CurrenciesStreamFileDescriptorSupplier
            extends CurrenciesStreamBaseDescriptorSupplier {
        CurrenciesStreamFileDescriptorSupplier() {
        }
    }

    private static final class CurrenciesStreamMethodDescriptorSupplier
            extends CurrenciesStreamBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        CurrenciesStreamMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (CurrenciesStreamGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new CurrenciesStreamFileDescriptorSupplier())
                            .addMethod(getGetCurrenciesRateMethodHelper())
                            .build();
                }
            }
        }
        return result;
    }
}
