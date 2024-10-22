package com.pen.validations;

import java.time.LocalDate;

import com.pen.core.Brand;
import com.pen.custom_exception.PenException;

public class PenValidations {
	public static int MIN_PRICE=10;
	
	public static Brand parsePenBrand(String pen) {
		return Brand.valueOf(pen.toUpperCase());
	}
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	public static void validatePrice(double price) throws PenException {
		if(price < MIN_PRICE){
			throw new PenException("Invalid Price of Pen!!");
		}
	}
	
//	public static void validateBrand(Brand type)throws PenException {
//		for(Brand pentype : Brand.values()) {
//			if(!pentype.name().equals(type.name()))
//				throw new PenException("Pen Brand Type not Valid!!");
//		}
//	}
	
	
}
