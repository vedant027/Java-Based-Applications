package comm.mybank.operations;

import comm.mybank.core.BankAccount;
import comm.mybank.core.BankAccountType;
import static comm.mybank.validations.BankingValidations.*;

import comm.mybank.customOrdering.BankAccountBalanceComparator;
import comm.mybank.custom_exceptions.BankingException;

import java.time.LocalDate;
import java.util.*;

public class BankOperationImpl implements BankOperations{
    private List<BankAccount> accounts;
    private int counter;

    public BankOperationImpl(){
        accounts = new ArrayList<>();
        //populate list
        BankAccount a1 = new BankAccount(101, BankAccountType.SAVING, 15000,"a1","b1",LocalDate.parse("1990-12-17"));
        BankAccount a2 = new BankAccount(10, BankAccountType.SAVING, 17000,"a2","b2",LocalDate.parse("1993-12-17"));
        BankAccount a3 = new BankAccount(55, BankAccountType.CURRENT, 6000,"a3","b3",LocalDate.parse("1991-10-17"));
        BankAccount a4 = new BankAccount(20, BankAccountType.FD, 150000,"a4","b4",LocalDate.parse("1989-12-07"));
        BankAccount a5 = new BankAccount(81, BankAccountType.LOAN, 200000,"a5","b5",LocalDate.parse("1991-02-15"));
        BankAccount a6 = new BankAccount(62, BankAccountType.SAVING, 12000,"a6","b6",LocalDate.parse("1990-12-18"));
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);
        accounts.add(a6);
    }

    @Override
    public String openBankAcc(int acctNo, String acType, double balance, String firstName, String lastName, String dob) throws BankingException{
        validateAccountNo(acctNo,accounts);
        //Validate Inputs - AccountType,Balance
        BankAccountType type = parseBankAccountType(acType);
        validateBalance(type,balance);
        //Validate Age
        LocalDate birthDate = validateAge(dob);

        accounts.add(new BankAccount(acctNo,type,balance,firstName,lastName,birthDate));
        return "A/C Created Successfully for the customer "+firstName+" "+lastName;
    }

    @Override
    public void displayAllAccounts(){
        System.out.println("All Account's");
        for(BankAccount a: accounts) {
            if (a != null) {
                System.out.println(a);
            }
        }
    }


    @Override
    public void displayAccSummary(int accNo) throws BankingException{
        System.out.println("Summary of the Account");
        BankAccount acctNo = getAccountByAcctNo(accNo);
        System.out.println(acctNo);
    }

    private BankAccount getAccountByAcctNo(int acctNo) throws BankingException{
        BankAccount myAcc = new BankAccount(acctNo);

        int index=accounts.indexOf(myAcc);
        if(index == -1)
            throw new BankingException("Invalid A/C No !!");
        return accounts.get(index);
    }

    @Override
    public String depositAmount(int accNo, double amount) throws BankingException{
                System.out.println("Depositing Amount!!");
                BankAccount acctNo = getAccountByAcctNo(accNo);
                if(amount>0){
                    acctNo.setBalance(acctNo.getBalance() + amount);
                    return "Deposit Successful, current balance: " + acctNo.getBalance();
                }
                else {
                    throw new BankingException("Enter a valid amount!");
                }
    }

    @Override
    public String withdrawAmount(int accNo, double amount) throws BankingException{
                BankAccount acctNo = getAccountByAcctNo(accNo);
                System.out.println("Withdrawing Amount!!");

                validateBalance(acctNo.getAcType(),acctNo.getBalance()-amount);
                acctNo.setBalance(acctNo.getBalance()-amount);
                return "Withdraw Successful, Current balance: " + acctNo.getBalance();
    }

    @Override
    public String transferFunds(int saccNo, int daccNo, double amount) throws BankingException {
            BankAccount src = getAccountByAcctNo(saccNo);
            BankAccount dest = getAccountByAcctNo(daccNo);
            if(src.equals(dest)){
                throw new BankingException("Source and Destination accounts are same!");
            }
            withdrawAmount(saccNo,amount);
            depositAmount(daccNo,amount);

            return "Transfer Successful";
    }

    @Override
    public void sortAccountByAccountNumber() {
        System.out.println("Sorting Account by A/c No in asc order");
        Collections.sort(accounts);
        System.out.println(accounts.toString());
    }

    @Override
    public void sortAccountByBalance() {
        System.out.println("Sorting Accounts by Balance in desc order");
        Collections.sort(accounts,new BankAccountBalanceComparator());
        System.out.println(accounts.toString());
    }

    @Override
    public void sortAccountsByDOB(){
        Collections.sort(accounts,new Comparator<BankAccount>(){
            @Override
            public int compare(BankAccount a1,BankAccount a2){
               return a1.getDob().compareTo(a2.getDob());
            }
        });
        System.out.println(accounts.toString());
    }

    @Override
    public void namesOfCustomerByType(String accType) {
        BankAccountType type = parseBankAccountType(accType);

        for(BankAccount bk : accounts){
            if(bk.getAcType().equals(type))
                System.out.println("Name: " +bk.getFirstName() + " " + bk.getLastName());
        }
    }

    @Override
    public void closeAccount(int accNo) throws BankingException {
        BankAccount myacc = getAccountByAcctNo(accNo);
        accounts.remove(myacc);
    }

    @Override
    public void closeAccountByTypenDate(String acType, String date) {
        BankAccountType type = parseBankAccountType(acType);
        LocalDate DOB = LocalDate.parse(date);
        Iterator<BankAccount> itr = accounts.iterator();
        while(itr.hasNext()) {
            BankAccount bk = itr.next();
            if (bk.getAcType().equals(type) && bk.getDob().isAfter(DOB))
                itr.remove();
        }
    }
    
    
}

