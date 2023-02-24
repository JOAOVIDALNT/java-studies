import entities.Product;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 1390.0));
        list.add(new Product("Laptop", 3760.0));
        list.add(new Product("Headphone", 390.0));
        list.add(new Product("Tablet", 550.0));

        ProductService ps = new ProductService();


        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'L');
        double sum2 = ps.filteredSum(list, p -> p.getPrice() < 600.0);

        System.out.println("SUM: " + String.format("%.2f", sum));
        System.out.println("SUM: " + String.format("%.2f", sum2));


    }
}