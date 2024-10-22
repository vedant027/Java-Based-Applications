package com.pen.operations;

import static com.pen.validations.PenValidations.parseDate;
import static com.pen.validations.PenValidations.parsePenBrand;
//import static com.pen.validations.PenValidations.validateBrand;
import static com.pen.validations.PenValidations.validatePrice;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.pen.core.Brand;
import com.pen.core.Pen;
import com.pen.custom_exception.PenException;

public class PenOperationsImpl implements PenOperations {
	private Map<Integer,Pen> pens;
	
	public PenOperationsImpl() {
		pens = new HashMap<>();
	}

	@Override
	public void addnewPen(String penBrand, String penColor, String inkColor, String material, int stock,
			String stockuptdate, String stocklistdate, double price, double discount) throws PenException {
		Brand penb = parsePenBrand(penBrand);
		LocalDate uptDate = parseDate(stockuptdate);
		LocalDate listDate = parseDate(stocklistdate);
		validatePrice(price);
//		validateBrand(penb);
		
		Pen p = new Pen(penb,penColor,inkColor,material,stock,uptDate,listDate,price,discount);
		pens.put(p.getId(), p);
		System.out.println("Pen Successfully Added!!");
	}
	
	@Override
	public void displayPens() {
		pens.values().stream().forEach(s -> System.out.println(s));
	}
	
	@Override
	public void setDiscount() {
		for(Pen p : pens.values()) {
			int lastSoldDuration = Period.between(p.getStockuptdate(),p.getStocklistdate()).getMonths(); 
			if(lastSoldDuration>3) {
				p.setPrice(p.getPrice()*0.8);
				System.out.println("20% Discount Applied!!");
			}
		}
	}
	
	@Override
	public void removePen() {
		Iterator<Pen> itr = pens.values().iterator();
		while(itr.hasNext()) {
			Pen p = itr.next();
			int lastSold = Period.between(p.getStockuptdate(), p.getStocklistdate()).getMonths();
			if(lastSold>9) {
				itr.remove();
				System.out.println("Pen Removed!!");
			}
		}
	}
	
	@Override
	public void updateStock(int id,int qty)throws PenException {
		
		if(pens.containsKey(id)) {
			pens.values().stream().filter(s -> s.getId()==id).forEach(s->s.setStock(qty));
			System.out.println("Stock Updated");
		}
	}
}
