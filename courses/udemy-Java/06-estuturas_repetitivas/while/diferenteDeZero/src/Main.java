import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int soma = 0;

        while (x != 0) {
            soma = soma + x;
            x = sc.nextInt();
        }


        System.out.println(soma);

        // Debug para entender melhor a aplicação: soma acumula o valor antigo de x e adiciona o mais recente.



        sc.close();
    }
}
