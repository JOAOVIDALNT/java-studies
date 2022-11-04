package app;

import entities.Client;

public class Program {
    public static void main(String[] args) {

        Client c1 = new Client("João", "joao@gmail.com");
        Client c2 = new Client("João", "joao@gmail.com");

        String s1 = "test";
        String s2 = "test";

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));

        System.out.println(c1 == c2);
        System.out.println(s1 == s2); /* retorna true mas se fosse uma instancia ex: String s1 = new String("test"); retornaria falso */





    }
}
