package fruit.demo.gateway.gql;

import com.google.protobuf.Int64Value;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import fruit.demo.gateway.entity.types.Customer;
import fruit.demo.gateway.entity.types.Order;
import fruit.demo.gateway.gql.convert.FruitConvert;
import net.devh.boot.grpc.client.inject.GrpcClient;

@DgsComponent
public class OrderQuery {
    @GrpcClient("grpc-order")
    private fc.proto.order.OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    @DgsQuery
    public Order order(String id) {
        return FruitConvert.INSTANCE.map(orderServiceBlockingStub.order(Int64Value.newBuilder().setValue(Long.parseLong(id)).build()));
    }
}
