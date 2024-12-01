package demos;

public class StaticDemo {

	public static void main(String[] args) {
		System.out.println(" Using the class itself to print the pqr value ");
		System.out.println(B.pqr);
		
		B b1 = new B();
		B b2 = new B();
		B b3 = new B();
		
		System.out.println(b1.pqr);
		System.out.println(b2.pqr);
		System.out.println(b3.pqr);
		
		
		System.out.println(" Changing value of pqr though b2..");
		b2.pqr = 5000;
		
		
		System.out.println(b1.pqr);
		System.out.println(b2.pqr);
		System.out.println(b3.pqr);
		
		System.out.println(" Using the class itself to print the pqr value ");
		System.out.println(B.pqr);
		
		B.pqr = 9999;
		
		
		System.out.println(b1.pqr);
		System.out.println(b2.pqr);
		System.out.println(b3.pqr);
		
		System.out.println(" Using the class itself to print the pqr value ");
		System.out.println(B.pqr);

	}

}
