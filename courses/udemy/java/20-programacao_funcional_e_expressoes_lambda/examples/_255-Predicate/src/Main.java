import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Monitor", 900.00));
        list.add(new Product("Mouse", 60.00));
        list.add(new Product("Headset", 90.00));
        list.add(new Product("SSD", 130.00));

        list.removeIf(p -> p.getPrice() >= 100.00); // Expressão lambda inline


//        list.remove(new ProductPredicate()); // Implementação da interface
//        list.removeIf(Product::staticProductPredicate); // Reference method com método estático
//        list.removeIf(Product::nonStaticProductPredicate); // Reference method com método não estático

//        Predicate<Product> pred = p -> p.getPrice() >= 100.0; // Expressão lambda declarada
//        list.removeIf(pred);                                 // Expressão lambda declarada


        for (Product p : list) {
            System.out.println(p);
        }


    }
}