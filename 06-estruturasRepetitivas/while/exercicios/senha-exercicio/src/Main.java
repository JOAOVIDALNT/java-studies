import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int senha = sc.nextInt();

        while (senha != 2022) {
            System.out.println("Senha inválida");
            senha = sc.nextInt();
        }

         System.out.println("Login bem-sucedido");


        sc.close();
    }
}
