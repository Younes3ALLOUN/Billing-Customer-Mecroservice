package ma.enset.customerservice.service;

import ma.enset.customerservice.dtos.CustomerReqDto;
import ma.enset.customerservice.dtos.CustomerRespDto;
import ma.enset.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    List<CustomerRespDto> getallCustomer();
    CustomerRespDto getCustomer(String id) throws CustomerNotFoundException;
    CustomerRespDto addNewCustomer(CustomerReqDto customerReqDto);
    CustomerRespDto updateCustomer(String id, CustomerReqDto customerReqDto) throws CustomerNotFoundException;
    void deleteCustomer(String id);
}
