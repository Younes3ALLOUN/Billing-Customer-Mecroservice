package ma.enset.customerservice.web;

import ma.enset.customerservice.dtos.CustomerReqDto;
import ma.enset.customerservice.dtos.CustomerRespDto;
import ma.enset.customerservice.exceptions.CustomerNotFoundException;
import ma.enset.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "/custmerservice/api")
public class CustomerRestController {
    private CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }
    @GetMapping(path = "/customers")
    List<CustomerRespDto> allCustomer(){
        return service.getallCustomer();
    }
    @GetMapping(path = "/customer/{id}")
    CustomerRespDto getCustomer(@PathVariable String id) throws CustomerNotFoundException {
        return service.getCustomer(id);
    }
    @PostMapping(path = "/customer")
    CustomerRespDto newCustomer(@RequestBody CustomerReqDto customerReqDto){
        return service.addNewCustomer(customerReqDto);
    }
    @PutMapping(path = "customer/{id}")
    CustomerRespDto updateCustomer(@PathVariable String id,@RequestBody CustomerReqDto customerReqDto) throws CustomerNotFoundException {
        return service.updateCustomer(id, customerReqDto);
    }
    @DeleteMapping(path = "customers/{id}")
    void deleteCustomer(@PathVariable String id){
        service.deleteCustomer(id);
    }

}
