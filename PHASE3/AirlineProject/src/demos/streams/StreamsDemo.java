package demos.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
	            new Product(1, "Laptop", 1200.00, "Electronics", LocalDate.of(2024, 1, 15)),
	            new Product(2, "Phone", 800.00, "Electronics", LocalDate.of(2024, 2, 1)),
	            new Product(3, "Desk", 300.00, "Furniture", LocalDate.of(2024, 1, 10)),
	            new Product(4, "Chair", 150.00, "Furniture", LocalDate.of(2024, 3, 5)),
	            new Product(5, "Tablet", 500.00, "Electronics", LocalDate.of(2024, 2, 20)),
	            new Product(6, "Bookshelf", 200.00, "Furniture", LocalDate.of(2024, 1, 25))
	        );
		
		System.out.println(products);
		
		// Stream
		
		System.out.println("1. Basic Filtering and Mapping:");
		
		List<Product> elcetronicsProduct = products
				.stream()
				.filter ( p -> p.getCategory().equals("Electronics")  )
				.collect(Collectors.toList());
		
		for(Product p: elcetronicsProduct)		
		System.out.println(p.getName() +", "+ p.getPrice());
		
		
		List<String> elcetronicsProductNames = products
				.stream()
				.filter ( p -> p.getCategory().equals("Electronics")  )
				.map( p -> p.getName())
				.collect(Collectors.toList());
		
		for(String n: elcetronicsProductNames)		
		System.out.println(n);
		
		System.out.println("\n2. Sorting:");
        // Sort products by price (descending) and collect top 3
        List<Product> top3Expensive = products
        		.stream()
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .limit(2)
            .collect(Collectors.toList());
        top3Expensive.forEach(p -> System.out.println(p.getName() + ": $" + p.getPrice()));
        
        System.out.println("\n3. Statistics with Numeric Streams:");
        
        double minPrice = products.stream()
        .mapToDouble(Product::getPrice)
        .summaryStatistics().getMin();
        
        System.out.println("\n3. Min Price of all products: "+minPrice);
        
        // Matching
        boolean hasExpensiveProducts = products.stream()
                .anyMatch(p -> p.getPrice() > 1000);
        
        System.out.println("\n4. List has a product whose price is > 1000 : "+hasExpensiveProducts);
        
        Optional<Product> firstFurniture = products.stream()
                .filter(p -> p.getCategory().equals("Furniture"))
                .findFirst();
        if(firstFurniture.isPresent())
        System.out.println("\n5. First Furniture Product name is : "+firstFurniture.get().getName());
        
        products.stream().count(); // 6
        products.stream().filter(p -> p.getCategory().equals("Furniture")).count(); // 2
        
        // Challenge: How will you find the max priced furniture?
        double  maxPricedFurniture = products.stream().filter(p -> p.getCategory().equals("Furniture"))
        		. mapToDouble(Product::getPrice)
        		.summaryStatistics().getMax();
        System.out.println("\n6. Max Priced Furniture : "+maxPricedFurniture);

	}

}
