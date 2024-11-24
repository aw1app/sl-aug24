package airline.staff;

public class Pilot {
	
	// Data or Fields or properties 
	String name;
	int age;

	String from_dest;
	String to_dest;
	
	int licenseNo = 123456;
	
	
	//Constructors
	//Default constructor
	Pilot(){
		System.out.println(" default constructor called ..");
	}
	
	//custom constructors
	Pilot(String name, int age, int liceNo){
		System.out.println(" custom constructor called ..");
		this.name =  name;
		this.age =  age;
		this.licenseNo =  liceNo;
	}
	
	// Methods or Operations or Actions or functions
	void flies(String from, String to){
		
	}
	
	void landSafely(){
		
	}

	void displayDetails() {
		System.out.println("Name :"+ name + "; Age :"+ this.age +  "; Licence No :"+ this.licenseNo );
	}

}
