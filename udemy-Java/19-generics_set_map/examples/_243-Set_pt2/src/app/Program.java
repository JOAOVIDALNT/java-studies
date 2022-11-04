package app;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //union
        Set<Integer> c = new TreeSet<>(a); // passa outra coleção como arg, conjunto 'c' cópia de 'a'
        c.addAll(b); // faz a união de dois conjuntos
        System.out.println(c);

        //intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b); // faz a intersecção, mantém apenas os elementos em comum
        System.out.println(d);

        //difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b); // mantém apenas elementos que não existem no conjunto 'b'
        System.out.println(e);
    }
}
