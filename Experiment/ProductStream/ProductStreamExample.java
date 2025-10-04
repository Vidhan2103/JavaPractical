package ProductStream;
import java.util.*;
import java.util.stream.*;

public class ProductStreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 85000, "Electronics"),
            new Product("Phone", 45000, "Electronics"),
            new Product("Headphones", 4000, "Electronics"),
            new Product("Shirt", 2000, "Clothing"),
            new Product("Jeans", 3500, "Clothing"),
            new Product("Shoes", 5000, "Clothing"),
            new Product("Milk", 60, "Grocery"),
            new Product("Bread", 40, "Grocery"),
            new Product("Rice", 1200, "Grocery")
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((cat, prodList) -> 
            System.out.println(cat + " -> " + prodList));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((cat, prod) -> 
            System.out.println(cat + " -> " + prod.orElse(null)));

        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
