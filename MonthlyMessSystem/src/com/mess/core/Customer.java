package com.mess.core;

import java.time.LocalDate;

public class Customer {
	private int customerid;
	private static int idGenerator=1;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String Address;
	private LocalDate registerDate;
	private LocalDate planEndDate;
	private String phoneNo;
	private MESSPLAN messplan;
	private double final_amount;
	
	
	public Customer(String firstname, String lastname, String email, String password, String address,
			LocalDate registerDate,LocalDate planEndDate, String phoneNo, MESSPLAN messplan, double final_amount){
		super();
		this.customerid = idGenerator++;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.Address = address;
		this.registerDate = registerDate;
		this.planEndDate = planEndDate;
		this.phoneNo = phoneNo;
		this.messplan = messplan;
		this.final_amount = final_amount;
	}


	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", Address=" + Address + ", registerDate=" + registerDate
				+ ", planEndDate=" + planEndDate + ", phoneNo=" + phoneNo + ", messplan=" + messplan + ", final_amount="
				+ final_amount + "]";
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public LocalDate getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}


	public LocalDate getPlanEndDate() {
		return planEndDate;
	}


	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public MESSPLAN getMessplan() {
		return messplan;
	}


	public void setMessplan(MESSPLAN messplan) {
		this.messplan = messplan;
	}


	public double getFinal_amount() {
		return final_amount;
	}


	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	
	
	
	
}
