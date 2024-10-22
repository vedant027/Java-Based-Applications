package comm.mybank.validations;

import comm.mybank.core.BankAccount;
import comm.mybank.core.BankAccountType;
import comm.mybank.custom_exceptions.BankingException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class BankingValidations {
    private static int MIN_AGE;
    static{
        MIN_AGE=18;
    }

    public static BankAccountType parseBankAccountType(String acType){
        return BankAccountType.valueOf(acType.toUpperCase());
    }

    // Method for Validating BankAccount Type
    public static void validateBalance(BankAccountType acType,double balance) throws BankingException{
        //parsing String -> Enum
        if(balance < acType.getBalance()){
            throw new BankingException("Low Balance!");
        }
    }

    //Method for Validating Age
    public static LocalDate validateAge(String dob) throws BankingException{
        //Parse String to Date
        LocalDate date = LocalDate.parse(dob);
        // Date to Age
        int age = Period.between(date,LocalDate.now()).getYears();
        if(age<MIN_AGE)
            throw new BankingException("Invalid Age!");
        return date;
    }

    public static void validateAccountNo(int acctNo, List<BankAccount> accounts) throws BankingException{
        BankAccount myacc = new BankAccount(acctNo);
        if(accounts.contains(myacc)){
            throw new BankingException("Account Number already exists");
        }
    }
}
