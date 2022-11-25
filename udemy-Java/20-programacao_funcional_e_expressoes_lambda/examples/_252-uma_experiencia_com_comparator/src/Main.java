import entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();


        list.add(new Product("Notebook", 3700.00));
        list.add(new Product("Celular", 1100.00));
        list.add(new Product("Air Fryer", 400.00));
        list.add(new Product("Headphone", 80.00));

        // Comparator como objeto de classe anônima
//        Comparator<Product> comp = new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//            }
//        };

        // Comparator como objeto de expressão lambda com chaves
//        Comparator<Product> comp = (p1, p2) -> {
//            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//        }; // expressão lambda

        // Comparator com objeto de expressão lambda sem chaves
//        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        // comparator na instância do sort
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }

    }
}