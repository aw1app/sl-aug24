package demos;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		Predicate<Integer> even = i -> {
			boolean b = i % 2 == 0;
			return b;
		};
		
		System.out.println(even.test(50));
		
		System.out.println(even.test(75));
		
	}

}
