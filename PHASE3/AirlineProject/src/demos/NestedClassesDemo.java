package demos;

public class NestedClassesDemo {

	public static void main(String[] args) {
		
		P p1 = new P();
		p1.x = 10;
		
		
		P.Q q1 = p1.new Q();
		q1.a=1000;
		
		
		//P.R r1 = P.new R();
		//P.Q q2=new P.Q();
		

	}

}
