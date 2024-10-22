package com.mess.operations;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.mess.core.Customer;
import com.mess.core.MESSPLAN;
import com.mess.custom_exception.CustomerException;

import static com.mess.validations.CustomerValidation.*;

public class CustomerOperationsImpl implements CustomerOperations {
	private Map<String,Customer> cust;
	
	public CustomerOperationsImpl() {
		cust = new HashMap<>();
// String firstname, String lastname, String email, String password, String address,
//		LocalDate registerDate, String phoneNo, MESSPLAN messplan, double final_amount
		cust.put("rajesh.sharma@gmail.com", new Customer("Rajesh", "Sharma", "rajesh.sharma@gmail.com", "rajesh", "Mumbai", 
			    LocalDate.of(2024, 10, 25),LocalDate.of(2025, 1, 25), "9876512345",  MESSPLAN.QUARTERLY, 11700));
//
		cust.put("sneha.patel@gmail.com", new Customer("sneha", "Patel", "sneha.patel@gmail.com", "sneha@123", "Pune", 
                LocalDate.of(2025, 1, 15),LocalDate.of(2025, 6, 15), "9876543210", MESSPLAN.MONTHLY, 4500));
//
		cust.put("arun.kumar@gmail.com", new Customer("Arun", "Kumar", "arun.kumar@gmail.com", "arun@2024", "Delhi", 
                LocalDate.of(2024, 12, 1),LocalDate.of(2025, 1, 1), "9876567890", MESSPLAN.YEARLY, 40000));
//
		cust.put("priya.menon@gmail.com", new Customer("priya", "Menon", "priya.menon@gmail.com", "priya#pass", "Bangalore", 
                LocalDate.of(2024, 11, 20),LocalDate.of(2025, 5, 20), "9876509876", MESSPLAN.QUARTERLY, 11700));
//
		cust.put("amit.singh@gmail.com", new Customer("Amit", "Singh", "amit.singh@gmail.com", "amit@1234", "Akurdi", 
                LocalDate.of(2024, 11, 30),LocalDate.of(2024, 12, 30), "9876523456", MESSPLAN.MONTHLY, 4500));
	}

	@Override
	public void signUpCustomer(String firstname, String lastname, String email, String password, String address,
			String registerDate, String phoneNo, String messplan, double final_amount) throws CustomerException {
		
		MESSPLAN mplan = validateMessPlan(messplan);
		LocalDate regDate = validateRegistrationDate(registerDate);
		LocalDate doe = planEndingDate(regDate, mplan);

		checkForDuplicates(email, cust);
		validateCustomer(email, password);
		validatePlan(mplan, final_amount);
		validatePhoneNo(phoneNo);
		
		Customer c = new Customer(firstname,lastname,email,password,address,regDate,doe,phoneNo,mplan,final_amount);
		cust.put(email, c);
		System.out.println("Customer Successfully Added");
	}
	
	@Override
	public void displayCustomers() throws CustomerException {
		cust.values().stream().forEach(i -> System.out.println(i));
		
		if(cust.isEmpty())
			throw new CustomerException("No Customers in System!!");
	}
	
	public Customer getCustomerByEmail(String email) throws CustomerException {
		Customer c = cust.get(email);
		if(c==null) {
			throw new CustomerException("Email doesn't exists!!");
		}
		return c;
	}
	
	

	@Override
	public void signInCustomer(String email, String password) throws CustomerException {
		Customer c = getCustomerByEmail(email);
		if(c.getPassword().equals(password)) {
			System.out.println("Successful Login!!");
		}
		else {
			throw new CustomerException("Invalid Password!");
		}
	}
	
	
	@Override
	public void changePassword(String email, String newPassword, String oldPassword) throws CustomerException {
		Customer c = getCustomerByEmail(email);
		if(c.getPassword().equals(oldPassword)) {
			c.setPassword(newPassword);
			System.out.println("Password Successfully Updated");
		}
		else {
			throw new CustomerException("Incorrect Password");
		}
	}

	public LocalDate planEndingDate(LocalDate regDate,MESSPLAN plan) throws CustomerException{
			LocalDate doe = regDate.plusMonths(plan.getPlanduration());
			return doe;		
	}

	@Override
	public void sortCustomerByName() {
		cust.values().stream().sorted(Comparator.comparing(Customer::getFirstname)).forEach(s -> System.out.println(s));	
	}

	@Override
	public void sortCustomerByPlan() {
		cust.values().stream().sorted(Comparator.comparing(Customer::getMessplan)).forEach(s -> System.out.println(s));
		
	}

	@Override
	public void sortCustomerByRgstDate() {
		cust.values().stream().sorted(Comparator.comparing(Customer::getRegisterDate)).forEach(s -> System.out.println(s));
	}

	@Override
	public void unSubscribeCustomerByPlan(String plan) throws CustomerException {
		MESSPLAN mplan = validateMessPlan(plan);
		cust.values().removeIf(s -> s.getMessplan().equals(mplan));	
	}

	@Override
	public void modifyCustomerFirstName() {
		for(Customer c : cust.values()) {
			String s = c.getFirstname().substring(0,1).toUpperCase() + c.getFirstname().substring(1);
			c.setFirstname(s);
		}
		
		cust.values().stream().forEach(s -> System.out.println(s));
	}

	@Override
	public void registeredInJan() {
		cust.values().stream().filter(s -> s.getRegisterDate().getMonth().name().equals("JANUARY")).forEach(s -> System.out.println(s.getEmail()));	
	}

	@Override
	public void customerRegisteredForMonthly() {
		long count = cust.values().stream().filter(s -> s.getMessplan().equals(MESSPLAN.MONTHLY)).count();
		System.out.println(count);
		
	}

	@Override
	public void customerOfAkurdi() {
		cust.values().stream().filter(s -> s.getAddress()=="Akurdi").forEach(s -> System.out.println(s));
	
	}

	@Override
	public void discountForYearly() {
		cust.values().stream().filter(s -> s.getMessplan().equals(MESSPLAN.YEARLY)).forEach(s -> s.setFinal_amount(s.getFinal_amount()*0.8));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
