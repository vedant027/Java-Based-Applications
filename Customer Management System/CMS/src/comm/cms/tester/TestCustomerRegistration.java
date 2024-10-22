package comm.cms.tester;

import comm.cms.operations.CustomerOperations;
import comm.cms.operations.CustomerOperationsImpl;

import java.util.Scanner;

public class TestCustomerRegistration {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            CustomerOperations ops = new CustomerOperationsImpl();
            boolean exit = false;
            while(!exit){
                System.out.println("Options 1. Sign Up \n" + "2. Sign In \n" + "3. Change Password\n"
                        + "4. UnSubscribe Customer \n"
                        + "5. Display all Customers \n"
                        + "0. Exit \n");
                System.out.println("Choose Options");
                try{
                    switch(sc.nextInt()){
                        case 1:
                            System.out.println("Enter Customer Details :- Firstname, Lastname, Email, Password, Registration Amount, Date of Birth, Service Plan");
                            ops.signUp(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
                            break;
                        case 2:
                            System.out.println("Enter Customer Registered EmailId and Password");
                            ops.signIn(sc.next(),sc.next());
                            break;
                        case 3:
                            System.out.println("Enter Registered EmailId, Old Password and New Password");
                            ops.changePassword(sc.next(),sc.next(),sc.next());
                            break;
                        case 4:
                            System.out.println("Enter Customer EmailId ");
                            ops.unSubscribeCustomer(sc.next());
                            break;
                        case 5:
                            ops.displayAllCustomer();
                            break;
                        case 0:
                            exit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    sc.nextLine();
                }
            }
        }
    }
}
