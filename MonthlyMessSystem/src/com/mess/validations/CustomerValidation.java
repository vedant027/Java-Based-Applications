package com.mess.validations;

import java.time.LocalDate;
import java.util.Map;

import com.mess.core.Customer;
import com.mess.core.MESSPLAN;
import com.mess.custom_exception.CustomerException;

public class CustomerValidation {
	public static MESSPLAN validateMessPlan(String plan) throws CustomerException {
		try {
			MESSPLAN mplan = MESSPLAN.valueOf(plan.toUpperCase());
				return mplan;
		}
		catch(IllegalArgumentException e){
			throw new CustomerException("Invalid Mess Plan!!");
		}
	}
	
	public static void checkForDuplicates(String email,Map<String,Customer> cust) throws CustomerException {
		if(cust.containsKey(email))
			throw new CustomerException("Customer Id Already Exists!!");
	}
	
	public static void validateCustomer(String mail,String password) throws CustomerException {
		if(!mail.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomerException("Invalid EmailId!!");
		if(password.isEmpty())
			throw new CustomerException("Password Can't be Empty!!");
	}
	
	public static void validatePlan(MESSPLAN plan,double amount) throws CustomerException {
			if(plan.getPlanbill()!=amount)
				throw new CustomerException("Invalid Plan Amount!!");
		
	}
	
	public static LocalDate validateRegistrationDate(String date) throws CustomerException {
		LocalDate doj = LocalDate.parse(date);
		if(doj.isBefore(LocalDate.now()))
			throw new CustomerException("Registration Date cann't be before today's date!!");

		return doj;
	}
	
	public static void validatePhoneNo(String phoneno) throws CustomerException {
		if(phoneno.length()==0 || !phoneno.matches("^\\d{10}$"))
			throw new CustomerException("Phone Number is inValid!!");
	}
	
//	public static void validateEmail(String email,Map<Integer,Customer> cust)throws CustomerException{
//		cust.values().stream().filter(s->s.getEmail().equals(email)).forEach(s -> return s);
//	}
	
}
