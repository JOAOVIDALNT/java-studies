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

        list.removeIf(p -> p.getPrice() >= 100.00);


//        list.remove(new ProductPredicate()); -> aplicando através da interface funcional
//        list.removeIf(Product::staticProductPredicate); -> aplicando através de um método estático dentro da classe product
//        list.removeIf(Product::nonStaticProductPredicate); -> através de um método não estático

//        Predicate<Product> pred = p -> p.getPrice() >= 100.0;
//        list.removeIf(pred);


        for (Product p : list) {
            System.out.println(p);
        }


    }
}