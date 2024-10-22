package comm.mybank.custom_exceptions;

public class BankingException extends Exception{
    public BankingException(String errMsg){
        super(errMsg);
    }
}
