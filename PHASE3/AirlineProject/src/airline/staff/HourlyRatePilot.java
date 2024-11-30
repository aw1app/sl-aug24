package airline.staff;

public abstract class HourlyRatePilot extends Pilot{
	
	int x = 100;
	
	public HourlyRatePilot(String name, int i, int j) {
		super(name,i,j);
		//this.x = 999;
	}

	@Override
	public void displayDetails() {
		System.out.println("[Hourly Rate Contract Pilot ] " + "Name :"+ name + "; Age :"+ this.age +  "; Licence No :"+ this.licenseNo );
		System.out.println("[ x = ] " + this.x);
	}
	
	//Reason 1 to create an abstract method:  we don't know what to code in the body
	abstract public void setContractTerms();
	
	////Reason 2 to create an abstract method: Force sub classes to provide the implementation
	abstract public void verifyIdentity();
	

}
