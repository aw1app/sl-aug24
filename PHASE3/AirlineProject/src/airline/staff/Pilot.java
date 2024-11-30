package airline.staff;

public class Pilot {
	
	// Data or Fields or properties 
	public String name;
	protected int age;
	
	public int x = 10;

	String from_dest;
	String to_dest;
	
	protected int licenseNo = 123456;
	
	
	//Constructors
	//Default constructor
	public Pilot(){
		System.out.println(" default constructor called ..");
	}
	
	//custom constructors
	public Pilot(String name, int age, int liceNo){
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

	public void displayDetails() {
		System.out.println("[Regular Employee Pilot ] " + "Name :"+ name + "; Age :"+ this.age +  "; Licence No :"+ this.licenseNo );
	}

}
