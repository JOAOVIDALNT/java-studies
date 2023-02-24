import entities.Product;
import util.PriceUpdate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Monitor", 900.00));
        list.add(new Product("Mouse", 60.00));
        list.add(new Product("Headset", 90.00));
        list.add(new Product("SSD", 130.00));

//        list.forEach(new PriceUpdate()); // Implementação da Interface
//        list.forEach(Product::staticPriceUpdate); // Reference method com método estático
//        list.forEach(Product::nonStaticPriceUpdate); // Reference method com método não estático
//        Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1); // Expressão lambda declarada
//        list.forEach(cons);                                          // Expressão lambda declarada
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1)); // Expressão lambda inline


        list.forEach(System.out::println);


    }
}