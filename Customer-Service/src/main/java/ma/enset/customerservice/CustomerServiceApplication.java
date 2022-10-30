package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository repository){
        return args -> {
            Stream.of("adam","mark","jack","bro").forEach(name->{
            Customer customer =Customer.builder()
                    .id(UUID.randomUUID().toString())
                    .name(name)
                    .email(name+"@gmail.com")
                    .build();
            repository.save(customer);
            });
        };
    }

}
