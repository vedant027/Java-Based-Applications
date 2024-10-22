package com.pen.core;

import java.time.LocalDate;

public class Pen {
	private int Id;
	private static int idgenerator=1;
	private Brand penBrand;
	private String penColor;
	private String inkColor;
	private String material;
	private int stock;
	private LocalDate stockuptdate;
	private LocalDate stocklistdate;
	private double price;
	private double discount;
	
	public Pen() {
		
	}
	
	public Pen(Brand penBrand, String penColor, String inkColor, String material, int stock,
			LocalDate stockuptdate, LocalDate stocklistdate, double price, double discount) {
		super();
		this.Id = idgenerator++;
		this.penBrand = penBrand;
		this.penColor = penColor;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockuptdate = stockuptdate;
		this.stocklistdate = stocklistdate;
		this.price = price;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Pen [Id=" + Id + ", penColor=" + penColor + ", inkColor=" + inkColor + ", material=" + material
				+ ", stock=" + stock + ", stockuptdate=" + stockuptdate + ", stocklistdate=" + stocklistdate
				+ ", price=" + price + ", discount=" + discount + "]";
	}

	public int getId() {
		return Id;
	}

	public Brand getPenBrand() {
		return penBrand;
	}

	public void setPenBrand(Brand penBrand) {
		this.penBrand = penBrand;
	}

	public String getPenColor() {
		return penColor;
	}

	public void setPenColor(String penColor) {
		this.penColor = penColor;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStockuptdate() {
		return stockuptdate;
	}

	public void setStockuptdate(LocalDate stockuptdate) {
		this.stockuptdate = stockuptdate;
	}

	public LocalDate getStocklistdate() {
		return stocklistdate;
	}

	public void setStocklistdate(LocalDate stocklistdate) {
		this.stocklistdate = stocklistdate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}

