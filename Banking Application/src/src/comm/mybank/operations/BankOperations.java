package comm.mybank.operations;

import comm.mybank.custom_exceptions.BankingException;

public interface BankOperations {
    String openBankAcc(int acctNo, String acType, double balance, String firstName, String lastName, String dob) throws BankingException;

    void displayAllAccounts();

    void displayAccSummary(int accNo) throws BankingException;

    String depositAmount(int accNo,double amount) throws BankingException;

    String withdrawAmount(int accNo,double amount) throws BankingException;

    String transferFunds(int saccNo,int daccNo,double amount) throws BankingException;

    void sortAccountByAccountNumber();

    void sortAccountByBalance();

    void sortAccountsByDOB();

    void namesOfCustomerByType(String accType);

    void closeAccount(int accNo) throws BankingException;

    void closeAccountByTypenDate(String acType, String date);
}
