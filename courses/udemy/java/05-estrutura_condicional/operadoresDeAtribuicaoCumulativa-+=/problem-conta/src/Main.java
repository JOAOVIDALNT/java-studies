import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        int minutes = sc.nextInt();

        double bill = 50.0;

        if (minutes > 100) {
            // bill = bill + (minutes - 100) * 2.0;
            bill += (minutes - 100) * 2.0; // operador de atribuiçao cumulativa +=

            
        }

        System.out.printf("Conta: R$%.2f%n", bill);
        sc.close();

    }


}
