package ma.enset.invoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class Invoice {
    @Id
    private String id;
    private Date date;
    private Double amount;
    private String customerId;
    @Transient
    private  Customer customer;


}
