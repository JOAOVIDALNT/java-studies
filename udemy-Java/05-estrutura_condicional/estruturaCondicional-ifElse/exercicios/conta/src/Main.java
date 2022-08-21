import java.util.Scanner;

public class Main {

  
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int codigo = sc.nextInt();
        int quantia = sc.nextInt();

        double total;

        String produto;

        if (codigo == 1) {
            total = quantia * 4.00;
            produto = "Cachorro Quente";
        }

        else if (codigo == 2) {
            total = quantia * 4.50;
            produto = "X-Salada";
        }

        else if (codigo == 3) {
            total = quantia * 5.00;
            produto = "X-Bacon";
        }

        else if (codigo == 4) {
            total = quantia * 2.00;
            produto = "Torrada";
        }

        else  {
            total = quantia * 1.50;
            produto = "Suco";
        }

        System.out.printf("Código: %d, %s. Total: R$%.2f%n", codigo, produto, total);


        sc.close();
    }

}