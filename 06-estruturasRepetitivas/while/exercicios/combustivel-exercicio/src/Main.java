import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int gasolina = 0;
        int diesel = 0;
        int alcool = 0;

        int comb = sc.nextInt();

        while (comb != 4) {

            if (comb == 1) {
                gasolina += 1;
            }
            else if (comb == 2) {
                diesel += 1;
            }
            else if (comb == 3) {
                alcool += 1;
            }

            comb = sc.nextInt();
        }

        System.out.println("Muito Obrigado");
        System.out.printf("Gasolina: %d%n", gasolina);
        System.out.printf("Diesel: %d%n", diesel);
        System.out.printf("Alcool: %d%n", alcool);

        sc.close();
    }
}
