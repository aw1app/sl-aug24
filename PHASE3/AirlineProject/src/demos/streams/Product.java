package demos.streams;

import java.time.LocalDate;

public class Product {
	private int id;
	private String name;
	private double price;
	private String category;
	private LocalDate createDate;

	public Product(int id, String name, double price, String category, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.createDate = createDate;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return String.format("Product{id=%d, name='%s', price=%.2f, category='%s', createDate=%s}", id, name, price,
				category, createDate);
	}
}
