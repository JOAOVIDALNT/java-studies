package app;

import entities.Product;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("Notebook", 2500.00);
        Product p2 = new Product("Celphone", 1350.00);
        Product p3 = new Product("Headphone", 250.00);

        stock.put(p1, 3000.00);
        stock.put(p1, 5000.00);
        stock.put(p1, 7000.00);

        Product ps = new Product("Notebook", 2500.00);

        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
        /* retorna false pois ainda não adicionei o hashcode e equals, dessa forma ele compara por
        * ponteiro de objeto, sendo p1 e ps objetos diferentes */

        // depois de adicionar hashcode e equals retorna true.

    }
}
