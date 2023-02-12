package app;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName: " + path.getName()); // exibe apenas o nome do arquivo sem o caminho
        System.out.println("getParent: " + path.getParent()); // exibe apenas o caminho
        System.out.println("getPath: " + path.getPath()); // exibe todo o caminho com o nome



        sc.close();
    }
}
