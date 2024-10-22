package com.pen.operations;

import com.pen.core.Brand;
import com.pen.custom_exception.PenException;

public interface PenOperations {
	void addnewPen(String penBrand, String penColor, String inkColor, String material, int stock,
			String stockuptdate, String stocklistdate, double price, double discount) throws PenException;
	
	void displayPens();
	
	void setDiscount();
	
	void removePen();
	
	void updateStock(int id,int qty) throws PenException;
}
