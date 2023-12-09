/* --------------- packages section --------------- */
package model.entities;

/* --------------- Product class --------------- */
public class Product {

	/* --------------- attributes section --------------- */
	private String name;
	private Double price;
	private Integer quantity;
	
	/* --------------- constructors  section --------------- */
	public Product() {
	}
	
	public Product(String name, Double price, Integer quantity) {
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	/* --------------- getters and setters section --------------- */
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	private void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/* --------------- methods section --------------- */
	public final Double totalValue() {
		return this.getPrice() * this.getQuantity();
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.2f, %d", this.getName(), this.getPrice(), this.getQuantity());
	}
}
