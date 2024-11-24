package airline.materials;

import java.util.Date;

public class Ticket {
	
	Date flightDate;
	int ticketNo;
	
	
	public Ticket(Date flightDate, int ticketNo) {
		super();
		this.flightDate = flightDate;
		this.ticketNo = ticketNo;
	}
	
	void displayDetails() {
		System.out.println("flightDate :"+ this.flightDate + "; ticketNo No :"+ this.ticketNo );
	}

}
