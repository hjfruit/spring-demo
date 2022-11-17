package fruit.demo.gateway.gql.convert;

import fruit.demo.gateway.entity.types.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface FruitConvert {
    FruitConvert INSTANCE = Mappers.getMapper(FruitConvert.class);

    Customer map(fc.proto.customer.Customer customer);
}
