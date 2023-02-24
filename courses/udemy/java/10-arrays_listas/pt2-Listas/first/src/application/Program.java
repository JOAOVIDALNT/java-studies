package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(); // ->  arrayList é a melhor forma de instanciar uma lista
        List<String> list = new ArrayList<>();
        // não aceita tipos primitivos 'int'

        list.add("João");
        list.add("Giulia");
        list.add("Arthur");
        list.add("Amelie");

        //adicionando na posição 2
        list.add(2, "Marcos");

        System.out.println(list.size()); // exibe o tamanho da lista

        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("------------------------------------------------------------------");
//        list.remove("Arthur"); // remove o nome que for identico
//        list.remove(2); // remove o objeto na posição 2
//        list.removeIf(x -> x.charAt(0) == 'A'); // função lambda predicado (true or false)

        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("------------------------------------------------------------------");

        System.out.println("Index of Giulia: " + list.indexOf("Giulia"));
        System.out.println("Index of João: " + list.indexOf("João"));

        System.out.println("------------------------------------------------------------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        for (String x : result) {
            System.out.println(x);
        }

        System.out.println("------------------------------------------------------------------");

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);


    }
}
