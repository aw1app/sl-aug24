package com.sl;

public class ProductV2 implements IProduct{
	
	String name;
	String desc;
	float price;
	
	Brand brand;
	
	public ProductV2() {
		
	}
		
	public ProductV2(String name, String desc, float price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public ProductV2(String name, String desc, float price, Brand brand) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.brand = brand;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	public String getDesc() {
		return desc;
	}
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}

	public String getName() {
		return name.toUpperCase();
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