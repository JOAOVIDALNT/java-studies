package app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
//                        new LinkedHashSet<>() -> mantém a ordem em que os elementos são inseridos
//                        new TreeSet<>(); -> mantém ordenado (string: alfabética)
//                        new HashSet<>(); -> não garante a ordem

        set.add("Televisão");
        set.add("Notebook");
        set.add("Celular");
        set.add("Tablet");
        set.add("Headphone");

        System.out.println(set.contains("Notebook")); // retorna true pois existe
        set.remove("Tablet");
        set.removeIf(x -> x.length() >= 3); // remove elemento x tal que length seja > ou = 3
        set.removeIf(x -> x.charAt(0) == 'T');

        for (String p : set) {
            System.out.println(p); // hashset não garante a ordem
        }

    }
}
