package demos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import airline.staff.Pilot;

public class ExceptionsDemo {
	
	public static void main(String[] args) {
		FileWriter f = null;
		
		try {
			 f = new FileWriter("F:\\Users\\home\\git\\sl-aug24\\PHASE3\\AirlineProject\\src\\a.txt");
			 f.write("World");
		} catch (IOException e) {
			
			//
		}finally {
			// use this finally block to do some clean up work
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

	public static void main1(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Pilot[] pilots = new Pilot[5];

		System.out.println(" Enter the pilot no number to create a pilot object for it: ");
		int num = scanner.nextInt();
		
		System.out.println(" Enter Pilot  name  ");
		String name = scanner.next();

		System.out.println(" Enter Pilot age  ");
		int age = scanner.nextInt();

		System.out.println(" Enter Pilot licence number  ");
		int lNo = scanner.nextInt();
		
		try {
		pilots[num] = new Pilot(name, age, lNo);
		
		//
		
		//
		
		}catch(ArrayIndexOutOfBoundsException ex){
			//
		}catch(InputMismatchException ex){
			//
		}catch(Exception ex){
			//
		}finally {
			// use this finally block to do some clean up work
		}

		//NOTE: When a try block can  multiple 
		
		System.out.println("Thank you for using this pilot creation app.)");

		scanner.close();
	}
	
	
	public static void main0(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" Enter how many apples: ");
		int a = scanner.nextInt();

		System.out.println(" Enter how many people: (don't type 0) ");

		try {
			int p = scanner.nextInt();
			System.out.println(" Each person will get  " + (a / p) + " apple(s)");
		} catch (ArithmeticException ex) {
			System.out.println("Sorry, you typed 0 people. Try again later)");
		}

		System.out.println("Thank you for using this apple sharing app.)");

		scanner.close();
	}

}
