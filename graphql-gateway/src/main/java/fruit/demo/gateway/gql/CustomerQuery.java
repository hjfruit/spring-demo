package fruit.demo.gateway.gql;

import com.google.protobuf.Int64Value;
import com.netflix.graphql.dgs.DgsComponent;
import fruit.demo.gateway.entity.types.Customer;
import fruit.demo.gateway.gql.convert.FruitConvert;
import net.devh.boot.grpc.client.inject.GrpcClient;


@DgsComponent
public class CustomerQuery {

    @GrpcClient("grpc-customer")
    private fc.proto.customer.CustomerServiceGrpc.CustomerServiceBlockingStub customerServiceBlockingStub;

    public Customer customer(String id) {
        return FruitConvert.INSTANCE.map(customerServiceBlockingStub.customer(Int64Value.newBuilder().setValue(Long.parseLong(id)).build()));
    }
}
