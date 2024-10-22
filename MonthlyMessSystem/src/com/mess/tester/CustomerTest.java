package com.mess.tester;

import java.util.Scanner;

import com.mess.operations.CustomerOperations;
import com.mess.operations.CustomerOperationsImpl;

public class CustomerTest {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			CustomerOperations ops = new CustomerOperationsImpl();
			boolean exit = false;
			while(!exit) {
				System.out.println("Choose Options: 1.SignUp Customer \n 2.SigIn Customer \n 3.Change Password \n"
						+ " 4.Sort Customer by FirstName \n 5.Sort Customer by MessPlan \n 6.Sort Customer by Registration Date \n"
						+ " 7.UnSubscribe Customer By Plan 8.Display all Customers \n 9.Modify Customer FirstName"
						+ "\n 10.Email Address of Customers Registered in January"
						+ "\n 11.Customer Registered For Monthly"
						+ "\n 12.Customer who lived in Akurdi"
						+ "\n 13.20% discount to customers for YEARLY \n 0.Exit ");
				System.out.print("Choose Options: ");
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer details: firstname, lastname, email, password, address,\r\n"
								+ " registerDate, phoneNo, messplan, final_amount");
						ops.signUpCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
						break;
					case 2:
						System.out.println("Enter Registered Email & Password");
						ops.signInCustomer(sc.next(), sc.next());
						break;
					case 3:
						System.out.println("Enter Registered Email, Old Password & New Password");
						ops.changePassword(sc.next(), sc.next(), sc.next());
						break;
					case 4:
						ops.sortCustomerByName();
						break;
					case 5:
						ops.sortCustomerByPlan();
						break;
					case 6:
						ops.sortCustomerByRgstDate();
						break;
					case 7:
						System.out.println("Enter Mess Plan");
						ops.unSubscribeCustomerByPlan(sc.next());
						break;
					case 8:
						ops.displayCustomers();
						break;
					case 9:
						ops.modifyCustomerFirstName();
						break;
					case 10:
						ops.registeredInJan();
						break;
					case 11:
						ops.customerRegisteredForMonthly();
						break;
					case 12:
						ops.customerOfAkurdi();
						break;
					case 13:
						ops.discountForYearly();
						break;
					case 0:
						exit=true;
						break;
					}
				}catch(Exception e){
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}
}
