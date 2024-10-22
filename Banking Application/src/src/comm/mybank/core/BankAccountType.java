package comm.mybank.core;

public enum BankAccountType {
    SAVING(10000),CURRENT(5000),FD(50000),LOAN(25000);
    private double MIN_BALANCE;
    private BankAccountType(double minBalance){ //constructor is private inside enum
        this.MIN_BALANCE=minBalance;
    }

    //getter
    public double getBalance(){
        return MIN_BALANCE;
    }
}
