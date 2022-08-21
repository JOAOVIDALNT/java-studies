package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        File file = new File("C:\\teste\\in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage()); // getMessage -> mensagem padrão do erro
        } finally {
            if (sc != null) {
                sc.close();
            } // bloco finally vai ser executado independente de dar certo ou não o try-catch
        }

        System.out.println("Finally block executed");



    }
}
