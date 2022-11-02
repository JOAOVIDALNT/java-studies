package app;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(5,2,10);
        printList(myInts);

        List<String> myStrs = Arrays.asList("João", "Giulia", "Amelie");
        printList(myStrs);
    }

    public static void printList(List<?> list) { /* O tipo super de lista não é List<Object> e sim
    List<?> - Não seria possivel fazer um upcasting de List<Integer> para List<Object> */
        for (Object obj : list) {
            System.out.println(obj);
        }

//        list.add(2); -> não é possivel adicionar um item a uma lista curinga, pois ela não reconhece o valor
    }
}
