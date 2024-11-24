package airline.staff;

import java.util.Arrays;

public class AirHostess {

	String name;
	int age;
	String[] services = null;

	AirHostess(String name, int age, String[] srvs) {
//		this.name = name;
//		this.age = age;
		this(name,age);
		this.services = srvs;
	}
	
	// Overloaded constructors
	AirHostess(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void displayDetails() {
		System.out.println("Name: " + name + "age: " + age + " offers services " + Arrays.toString(services));
	}
	
	
	void setServices(String[] srvs){
		this.services = srvs;
	}
	

}