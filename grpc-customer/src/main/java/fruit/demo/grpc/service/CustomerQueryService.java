package fruit.demo.grpc.service;

import com.google.protobuf.Int64Value;

import fc.proto.customer.Customer;
import fc.proto.customer.CustomerServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CustomerQueryService extends CustomerServiceGrpc.CustomerServiceImplBase {

    @Override
    public void customer(Int64Value request, StreamObserver<Customer> responseObserver) {
        responseObserver.onNext(Customer.newBuilder().setCustomerName("客户1").setCustomerAddress("地址1").setId(1).build());
        responseObserver.onCompleted();
    }
}
