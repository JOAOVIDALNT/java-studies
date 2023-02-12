        /*
        * podem haver alguns erros no programa, ex: usuário digitar uma posição inexistente no array
        *
         > João Giulia
         > 3
        -- > Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
	    at app.Program.main(Program.java:12)
	    *
	    * também pode ocorrer do usuário digitar um texto ao invés de um numero, e etc..
	    * a estrutura try-catch vem tratar desses erros
        */
package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" "); // -> split define o que separa os objetos
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) { // erro do exemplo acima
            System.out.println("Invalid position");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input"); // erro caso o input int receba outro tipo de entrada
        }


        System.out.println("End of program");



        sc.close();
    }
}
