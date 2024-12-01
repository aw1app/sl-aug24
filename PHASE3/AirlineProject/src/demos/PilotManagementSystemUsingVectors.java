package demos;

import java.util.Scanner;
import java.util.Vector;

import airline.staff.Pilot;

public class PilotManagementSystemUsingVectors {

	public static void main(String[] args) {
		System.out.println(" ** PILOT MANANGEMENT SYSTEM **\n\n ");

		Scanner scanner = new Scanner(System.in);

		// Create n pilots
		System.out.println(" How many pilots ");
		int noOfPilots = scanner.nextInt();

		Vector<Pilot> pilots = new Vector<Pilot>(noOfPilots);

		for (int i = 0; i <noOfPilots; i++) {

			System.out.println(" Enter Pilot " + (i + 1) + "'s name  ");
			String name = scanner.next();

			System.out.println(" Enter Pilot " + (i + 1) + "'s age  ");
			int age = scanner.nextInt();

			System.out.println(" Enter Pilot " + (i + 1) + "'s licence number  ");
			int lNo = scanner.nextInt();

			pilots.add(new Pilot(name, age, lNo));

		}

		// Search for the most aged pilot.
		// Let's use Linear search
		int indexOfMaxAge = 0;

		for (int i = 1; i < pilots.size(); i++) {
			if (pilots.get(i).getAge() > pilots.get(indexOfMaxAge).getAge())
				indexOfMaxAge = i;
		}
		;

		System.out.println("Eldest Pilot is " + pilots.get(indexOfMaxAge).name + " and his/her age is "
				+ pilots.get(indexOfMaxAge).getAge());
		
		
		// Remove pilot at index 1
		//pilots.remove(1);
		
		
		scanner.close();

	}

}
