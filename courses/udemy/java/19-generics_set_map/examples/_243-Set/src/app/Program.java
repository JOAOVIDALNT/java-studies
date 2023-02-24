package app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

//                        new LinkedHashSet<>() -> mantém a ordem em que os elementos são inseridos
//                        velocidade intermediária e elementos na ordem em que são adicionados

//                        new TreeSet<>(); -> mantém ordenado (string: alfabética)
//                        mais lento (operações O(long(n)) em árvore rubro-negra) e ordenado
//                        pelo compareTo do objeto (out Comparator)

//                        new HashSet<>(); -> não garante a ordem
//                        mais rápido (operaões O(1) em tabela hash) e não ordenado

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
