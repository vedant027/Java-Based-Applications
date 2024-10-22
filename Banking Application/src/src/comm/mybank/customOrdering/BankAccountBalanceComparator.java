package comm.mybank.customOrdering;

import comm.mybank.core.BankAccount;

import java.util.Comparator;

public class BankAccountBalanceComparator implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount a1, BankAccount a2){
        if(a2.getBalance()<a1.getBalance())
            return -1;
        if(a2.getBalance()==a1.getBalance())
            return 0;
        return 1;
//    	return a2.compareTo(a1);
    }
}
