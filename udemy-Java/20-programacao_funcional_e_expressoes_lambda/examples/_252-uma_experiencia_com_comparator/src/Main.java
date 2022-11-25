import entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();


        list.add(new Product("Notebook", 3700.00));
        list.add(new Product("Celular", 1100.00));
        list.add(new Product("Air Fryer", 400.00));
        list.add(new Product("Headphone", 80.00));

//        list.add(new Product(3700.00, "Notebook"));
//        list.add(new Product(1100.00, "Celular"));
//        list.add(new Product(400.00, "Air Fryer"));
//        list.add(new Product(80.00, "Headphone"));
//        // testei e mesmo que o primeiro parâmetro for preço o sort vai ordenar por nome

        Collections.sort(list);

        for (Product p : list) {
            System.out.println(p);
        }

    }
}