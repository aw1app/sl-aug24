

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Product{
	
	String name;
	String desc;
	float price;
	
	@Autowired
	Brand brand;
	
	public Product() {
		
	}
		
	public Product(String name, String desc, float price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public Product(String name, String desc, float price,Brand brand ) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.brand = brand;
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