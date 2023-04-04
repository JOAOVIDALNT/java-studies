package app;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        method1();
        System.out.println("End of program");

    }

    public static void method1() {
        System.out.println("==== METHOD1 START ====");
        method2();
        System.out.println("==== METHOD1 END ====");
    }

    public static void method2() {
        System.out.println("==== METHOD2 START ====");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" "); // -> split define o que separa os objetos
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) { // erro do exemplo acima
            System.out.println("Invalid position");
            e.printStackTrace(); // imprime o stack trace

        } catch (InputMismatchException e) {
            System.out.println("Invalid input"); // erro caso o input int receba outro tipo de entrada
        }

        sc.close();
        System.out.println("==== METHOD2 END ====");
    }
}
