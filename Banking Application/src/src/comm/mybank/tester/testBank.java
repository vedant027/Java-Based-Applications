package comm.mybank.tester;
import comm.mybank.core.*;

import java.time.LocalDate;
import java.util.Scanner;

public class testBank {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            System.out.println("Enter a/c details- " + "acctNo, acType,balance,firstName,lastName,dob(yyyy-MM-dd)");
            BankAccount acc1 = new BankAccount(sc.nextInt(),BankAccountType.valueOf(sc.next().toUpperCase()),sc.nextDouble(),sc.next(),sc.next(), LocalDate.parse(sc.next()));
            System.out.println(acc1);
            System.out.println("Enter a/c details- " + "acctNo, acType,balance,firstName,lastName,dob(yyyy-MM-dd)");
            BankAccount acc2 = new BankAccount(sc.nextInt(),BankAccountType.valueOf(sc.next().toUpperCase()),sc.nextDouble(),sc.next(),sc.next(), LocalDate.parse(sc.next()));
            System.out.println(acc2);
//            System.out.println(acc1=acc2);
            if(acc1.equals(acc2)) { // this will give false because the object class equals method is not overriden in the BankAccount class for this we need to override string class equals method in BankAccount
                System.out.println("Equal");
            }
            else{
                System.out.println("Different");
            }
        } // JVM - sc.close()
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
