package com.sl;

public class Product{
	
	String name;
	String desc;
	float price;
	
	Brand brand;
	
	public Product() {
		
	}
		
	public Product(String name, String desc, float price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public Brand getBrand() {
		return this.brand;
	}
	
	public String getDesc() {
		return desc;
	}
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}