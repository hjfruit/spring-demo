package demo.grpc.service;

import com.google.protobuf.Int64Value;
import fc.proto.order.Order;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class OrderQueryService extends fc.proto.order.OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void order(Int64Value request, StreamObserver<Order> responseObserver) {
        super.order(request, responseObserver);
    }
}
