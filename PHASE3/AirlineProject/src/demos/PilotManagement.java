package demos;

import java.util.Scanner;

import airline.staff.Pilot;

public class PilotManagement {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Pilot[] pilots = new Pilot[4];
		
		
		// Create 4 pilots
		for(int i=0; i<4 ; i++) {
			
			System.out.println(" Enter " + (i+1)  + "'s name  " );
			String name  = scanner.nextLine();
			
		}
		
		
	}

}
