package comm.cms.custom_exception;

public class CustomerValidationException extends Exception {
    public CustomerValidationException(String msg) {
        super(msg);
    }
}
