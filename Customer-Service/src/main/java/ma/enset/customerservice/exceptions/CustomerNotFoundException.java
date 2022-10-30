package ma.enset.customerservice.exceptions;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String format) {
        super(format);
    }
}
