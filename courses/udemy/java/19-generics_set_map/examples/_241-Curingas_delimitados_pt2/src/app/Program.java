package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(7.77, 6.66);
        List<Object> myObjects = new ArrayList<Object>();

        copy(myInts, myObjects);
        printList(myObjects);
        copy(myDoubles, myObjects);
        printList(myObjects);
    }

    public static void copy(List<? extends Number> source, List<? super Number> target) {
        // source list -> Covariância não obtem mas adiciona - target list -> contravariancia não adiciona mas obtem (get-put(add))
        for (Number number : source) {
            target.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
