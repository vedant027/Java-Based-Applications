package com.pen.tester;

import java.util.Scanner;

import com.pen.operations.PenOperations;
import com.pen.operations.PenOperationsImpl;

public class TestPen {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			PenOperations ops = new PenOperationsImpl();
			boolean exit = false;
			while(!exit) {
				System.out.println("Options:- 1.Add Pen \n 2.Display all Pens \n 3.Update Stock of Pen \n 4.Set Discount of 20% \n 5.Remove Pens Not Sold \n 0.Exit \n");
			System.out.print("Choose Options: ");
				try {
					switch(sc.nextInt()) {
						case 1:
							System.out.print("Add Pen Details: ");
							System.out.println("penBrand, penColor, inkColor, material, stock,\r\n"
									+ "stockuptdate, stocklistdate, price, discount");
							ops.addnewPen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
							break;
						case 2:
							ops.displayPens();
							break;
						case 3:
							System.out.println("Enter Pen ID Number & New Stock Amount: ");
							ops.updateStock(sc.nextInt(), sc.nextInt());
							break;
						case 4:
							ops.setDiscount();
							break;
						case 5:
							ops.removePen();
							break;
						case 0:
							exit = true;
							break;	
					}
				} catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}
}
