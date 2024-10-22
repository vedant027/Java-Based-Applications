package comm.mybank.core;
import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount> {
    private int acctNo;
    // HAS-A Relationship (BankAccount HAS-A BankAccount Type)
    private BankAccountType acType;
    private double balance;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public BankAccount(int acctNo,BankAccountType acType,double balance,String firstName,String lastName,LocalDate dob){
        this.acctNo=acctNo;
        this.acType=acType;
        this.balance=balance;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
    }

    public BankAccount(int acctNo){
        this.acctNo=acctNo;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                "acctNo=" + acctNo +
                ", acType=" + acType +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }

    public boolean equals(Object anotherObject){
        if(anotherObject instanceof BankAccount)
            return this.acctNo==((BankAccount)anotherObject).acctNo;
        return false;
    }

    public int getAcctNo(){
        return this.acctNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccountType getAcType() {
        return acType;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(BankAccount anotherAccount) {
        if(this.acctNo<anotherAccount.acctNo){
            return -1;
        }
        if(this.acctNo==anotherAccount.acctNo)
            return 0;
        return 1;
    }
}
