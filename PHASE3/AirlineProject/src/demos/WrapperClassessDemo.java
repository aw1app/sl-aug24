package demos;

public class WrapperClassessDemo {

	public static void main(String[] args) {
		//Convert String to Integer
		 //1. Construct Integer by using a 		constructor.
		 Integer num1 = new Integer("110");
		 System.out.println(num1);

		 //2. Use the valueOf method of Integer 		class.
		 String str = "100";
		 Integer num2 = Integer.valueOf(str);
		 System.out.println(num1);
		 
		 
		 Character c1 = new Character('A');
		 System.out.println(c1);
		 

	}

}
