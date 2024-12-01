package demos;

import java.util.Scanner;

import airline.staff.Pilot;

public class PilotManagement {

	public static void main(String[] args) {

		System.out.println(" ** PILOT MANANGEMENT SYSTEM **\n\n ");

		Scanner scanner = new Scanner(System.in);
		Pilot[] pilots = new Pilot[4];

		// Create 4 pilots
		for (int i = 0; i < 4; i++) {

			System.out.println(" Enter Pilot " + (i + 1) + "'s name  ");
			String name = scanner.next();

			System.out.println(" Enter Pilot " + (i + 1) + "'s age  ");
			int age = scanner.nextInt();

			System.out.println(" Enter Pilot " + (i + 1) + "'s licence number  ");
			int lNo = scanner.nextInt();

			pilots[i] = new Pilot(name, age, lNo);

		}

		// System.out.println(" Pilot no 3's name "+ pilots[2].name);

		// Search for the most aged pilot.
		// Let's use Linear search
		int indexOfMaxAge = 0;

		for (int i = 1; i < 4; i++) {
			if (pilots[i].getAge() > pilots[indexOfMaxAge].getAge())
				indexOfMaxAge = i;
		}
		;

		System.out.println("Eldest Pilot is " + pilots[indexOfMaxAge].name + " and his/her age is "
				+ pilots[indexOfMaxAge].getAge());

	}

}

// Challenge : Enhance above program to print if a pilot exist given a licence number;
