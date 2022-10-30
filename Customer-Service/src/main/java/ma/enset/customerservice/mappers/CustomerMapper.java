package ma.enset.customerservice.mappers;
import ma.enset.customerservice.dtos.CustomerReqDto;
import ma.enset.customerservice.dtos.CustomerRespDto;
import ma.enset.customerservice.entities.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface CustomerMapper {
    CustomerRespDto toCustomerRespDto(Customer customer);
    Customer toCustomer(CustomerReqDto customerReqDto);
}
