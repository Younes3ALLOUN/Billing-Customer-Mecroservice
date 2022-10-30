package ma.enset.customerservice.service;

import lombok.AllArgsConstructor;
import ma.enset.customerservice.dtos.CustomerReqDto;
import ma.enset.customerservice.dtos.CustomerRespDto;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.exceptions.CustomerNotFoundException;
import ma.enset.customerservice.mappers.CustomerMapper;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;
    private CustomerMapper mapper;
    @Override
    public List<CustomerRespDto> getallCustomer() {
        List<CustomerRespDto> listCustomer = repository.findAll()
                .stream()
                .map(customer -> mapper.toCustomerRespDto(customer))
                .collect(Collectors.toList());
        return listCustomer;
    }

    @Override
    public CustomerRespDto getCustomer(String id) throws CustomerNotFoundException {
        Customer customer=repository.findById(id)
                //TODO : test if that is valid
                .orElseThrow(()->new CustomerNotFoundException(String.format("customer with id : %s is not existe",id)));
        return mapper.toCustomerRespDto(customer);
    }

    @Override
    public CustomerRespDto addNewCustomer(CustomerReqDto customerReqDto) {
        Customer customer= mapper.toCustomer(customerReqDto);
        customer.setId(UUID.randomUUID().toString());
        Customer savedCus = repository.save(customer);
        return mapper.toCustomerRespDto(savedCus);
    }

    @Override
    public CustomerRespDto updateCustomer(String id, CustomerReqDto customerReqDto) throws CustomerNotFoundException {
        Customer customer=repository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(String.format("customer with id : %s is not existe",id)));
        if(customerReqDto.getName()!=null)customer.setName(customerReqDto.getName());
        if(customerReqDto.getEmail()!=null)customer.setEmail(customerReqDto.getEmail());
        Customer save = repository.save(customer);
        return mapper.toCustomerRespDto(save);
    }

    @Override
    public void deleteCustomer(String id) {
        repository.deleteById(id);

    }
}
