package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        File file = new File("c:\\projects\\test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally { // boa prática pois se colocar no try e der erro o scanner pode não fechar
            if (sc != null) { // se for nulo não precisa fechar, pois gera null pointer exception
                sc.close();
            }
        }

    }
}
