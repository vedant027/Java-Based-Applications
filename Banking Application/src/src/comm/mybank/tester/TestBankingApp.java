package comm.mybank.tester;

import comm.mybank.operations.BankOperationImpl;
import comm.mybank.operations.BankOperations;

import java.util.Scanner;

public class TestBankingApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BankOperations ops = new BankOperationImpl();
            boolean exit = false;
            while (!exit) {
                System.out.println("Options 1. Open A/C \n" + "2. Display all \n" + "3. Fetch A/c Summary\n "
                        + "4. Withdraw \n "
                        + "5. Deposit \n "
                        + "6. Funds Transfer \n "
                        + "7. Sort bank accounts ascending \n "
                        + "8. Sort accts as per balance(desc) \n "
                        + "9. Sort accts as per DOB(asc) \n "
                        + "10. Name of Customers by Specified Account Type \n "
                        + "11. Close Account \n "
                        + "12. Close Account By Specified Date \n "
                        + "0. Exit");
                System.out.println("Choose option");
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println(
                                    "Enter a/c details -  " + "acctNo, acType,  balance,  firstName ,lastName,	dob, doj");
                            System.out.println(ops.openBankAcc(sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(),
                                    sc.next(), sc.next()));
                            break;
                        case 2: // display all
                            ops.displayAllAccounts();
                            break;
                        case 3: // fetch particular a/c summary
                            System.out.println("Enter a/c no ");
                            ops.displayAccSummary(sc.nextInt());
                            break;
                        case 4: // withdraw funds
                            System.out.println("Enter a/c no n withdraw amount");
                            System.out.println(ops.withdrawAmount(sc.nextInt(),sc.nextDouble()));
                            break;
                        case 5: // deposit funds
                            System.out.println("Enter a/c no n deposit amount");
                            System.out.println(ops.depositAmount(sc.nextInt(),sc.nextDouble()));
                        case 6: // deposit funds
                            System.out.println("Enter src a/c no,dest a/c no n transfer amount");
                            System.out.println(ops.transferFunds(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
                        case 7 :
                            ops.sortAccountByAccountNumber();
                            break;
                        case 8 :
                            ops.sortAccountByBalance();
                            break;
                        case 9:
                            ops.sortAccountsByDOB();
                            break;
                        case 10:
                            System.out.println("Enter Account Type: ");
                            ops.namesOfCustomerByType(sc.next());
                            break;
                        case 11:
                            System.out.println("Enter Account no: ");
                            ops.closeAccount(sc.nextInt());
                            System.out.println("Account Successfully Deleted!");
                            break;
                        case 12:
                            System.out.println("Enter Account Type & Date of Joining: ");
                            ops.closeAccountByTypenDate(sc.next(),sc.next());
                            System.out.println("Accounts Successfully Deleted!");
                            break;
                        case 0:
                            exit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    sc.nextLine();// to read off pending input tokens from the scanner
                }
            }

        }

    }

}
