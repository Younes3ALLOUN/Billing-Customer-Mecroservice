package ma.enset.invoiceservice.repositories;

import ma.enset.invoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findAllByCustomerId(String id);
}
