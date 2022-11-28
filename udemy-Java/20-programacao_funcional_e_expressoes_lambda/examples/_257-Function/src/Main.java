import entities.Product;
import util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Monitor", 900.00));
        list.add(new Product("Mouse", 80.00));
        list.add(new Product("Headset", 100.00));
        list.add(new Product("Stream Deck", 520.00));

        // A operação map aplica a função que recebe como parâmetro ao elemento em questão
        // map só se aplica para stream() por isso a conversão de list pra stream

        // IMPLEMENTAÇÃO DA INTERFACE
//        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

        // REFERENCE METHOD COM MÉTODO ESTÁTICO
//        List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

        // REFERENCE METHOD COM MÉTODO NÃO ESTÁTICO
//        List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

        // EXPRESSÃO LAMBDA DECLARADA
//        Function<Product, String> func = product -> product.getName().toUpperCase();
//        List<String> names = list.stream().map(func).collect(Collectors.toList());

        // EXPRESSÃO LAMBDA INLINE
        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());



        names.forEach(System.out::println);

    }
}