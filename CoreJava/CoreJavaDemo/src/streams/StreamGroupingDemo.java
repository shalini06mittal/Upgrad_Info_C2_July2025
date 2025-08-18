package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
}
public class StreamGroupingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Product> products = Arrays.asList(
		            new Product("Laptop", "Electronics", 1200.00),
		            new Product("Mouse", "Electronics", 25.00),
		            new Product("Shirt", "Apparel", 40.00),
		            new Product("Jeans", "Apparel", 60.00),
		            new Product("Keyboard", "Electronics", 75.00)
		        );
		 Map<String, Long> prodCountingByCategory =
		 products.stream()
		 .collect(Collectors.groupingBy(prod -> prod.getCategory(), Collectors.counting()));
		 System.out.println(prodCountingByCategory);
		 
	}

}
