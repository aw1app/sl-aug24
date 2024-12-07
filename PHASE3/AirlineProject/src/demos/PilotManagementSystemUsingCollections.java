package demos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import airline.staff.AirHostess;
import airline.staff.Pilot;

public class PilotManagementSystemUsingCollections {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// listDemo(scanner);

		// priorityQueueDemo(scanner);

		hashMapDemo(scanner);

		scanner.close();
	}

	public static void hashMapDemo(Scanner scanner) {

		// Create n pilots
		System.out.println(" How many pilots ");
		int noOfPilots = scanner.nextInt();

		HashMap<Integer, Pilot> mapOfLNToPilot = new HashMap<Integer, Pilot>();

		for (int i = 0; i < noOfPilots; i++) {

			System.out.println(" Enter Pilot " + (i + 1) + "'s name  ");
			String name = scanner.next();

			System.out.println(" Enter Pilot " + (i + 1) + "'s age  ");
			int age = scanner.nextInt();

			System.out.println(" Enter Pilot " + (i + 1) + "'s licence number  ");
			int lNo = scanner.nextInt();

			mapOfLNToPilot.put(lNo, new Pilot(name, age, lNo));
		}
		
		
		// Search and get details of a pilot given a license no
		System.out.println(" Enter License No: ");
		int inputLNo = scanner.nextInt();
		Pilot pilot = mapOfLNToPilot.get(inputLNo);
		
		if(pilot!=null) {
			System.out.println("Pilot found with folllowing details :  " + pilot.name + " and his/her age is "
					+ pilot.getAge() + " and lic no is " + pilot.getLicenseNo());
		}else {
			System.out.println("Pilot not found with given license no!");
		}

	}

	public static void priorityQueueDemo(Scanner scanner) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(); // FIFO

		priorityQueue.add(1);
		priorityQueue.add(11);
		priorityQueue.add(7);
		priorityQueue.add(4);

		// Iteration
		priorityQueue.forEach(

				p -> {
					System.out.println(p);
				}

		);

		Integer i1 = priorityQueue.peek(); // priorityQueue.poll();

		System.out.println("i1=" + i1);
		System.out.println("priorityQueue.size() = " + priorityQueue.size());

//		Challenge: 
//			Create a PriorityQueue of Pilot objects
//			such that when we poll(), we should get the Eldest Pilot.

	}

	public static void listDemo(Scanner scanner) {
		System.out.println(" ** PILOT MANANGEMENT SYSTEM **\n\n ");

		// Create n pilots
		System.out.println(" How many pilots ");
		int noOfPilots = scanner.nextInt();

		// List<Pilot> pilots = new ArrayList<Pilot>();
		List<Pilot> pilots = new LinkedList<Pilot>();

		for (int i = 0; i < noOfPilots; i++) {

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
		// pilots.remove(1);

		System.out.println(" Iterating pilots list ...");
		for (Pilot p : pilots) {
			System.out.println(p.name);
		}
		;

		// Search for the most aged pilot.
		pilots.sort((p1, p2) -> p1.getAge() - p2.getAge());
		System.out.println("After sorting Eldest Pilot is " + pilots.getLast().name + " and his/her age is "
				+ pilots.getLast().getAge());

		// Another simplified for loop
		pilots.forEach(

				p -> {
					System.out.println(p.name);
					System.out.println(p.getAge());
				}

		);

	}

}

// Challenge : Add a property salary. 
// Enhance the above program to display the lowest salary pilot's name.
