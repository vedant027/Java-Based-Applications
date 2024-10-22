package com.mess.operations;

import java.time.LocalDate;

import com.mess.custom_exception.*;
import com.mess.core.Customer;
import com.mess.core.MESSPLAN;

public interface CustomerOperations {
	void signUpCustomer(String firstname, String lastname, String email, String password, String address,
			String registerDate, String phoneNo, String messplan, double final_amount) throws CustomerException;
	
	void signInCustomer(String email,String password) throws CustomerException;
	
	void changePassword(String email,String newPassword,String oldPassword) throws CustomerException;
	
	void sortCustomerByName();
	
	void sortCustomerByPlan();
	
	void sortCustomerByRgstDate();
	
	void unSubscribeCustomerByPlan(String plan) throws CustomerException;
	
	void displayCustomers() throws CustomerException;
	
	void modifyCustomerFirstName();
	
	void registeredInJan();
	
	void customerRegisteredForMonthly();
	
	void customerOfAkurdi();
	
	void discountForYearly();
}


