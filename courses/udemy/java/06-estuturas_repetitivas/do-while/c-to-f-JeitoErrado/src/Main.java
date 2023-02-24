import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // System.out.print("Digite a temperatura em Celsius: ");
        // double C = sc.nextDouble();

        // double F = 9.0 * C / 5.0 + 32.0;

        // System.out.printf("Equivalente: %.1f%n", F);

        // System.out.print("Deseja repetir y/n? ");
        // char res = sc.next().charAt(0);

        // while ( res != 'n') {
        //     System.out.print("Digite a temperatura em Celsius: ");
        //     C = sc.nextDouble();
    
        //     F = 9.0 * C / 5.0 + 32.0;
    
        //     System.out.printf("Equivalente: %.1f%n", F);
    
        //     System.out.print("Deseja repetir y/n? ");
        //     res = sc.next().charAt(0);
        // }

        
        // OU

        char res = 's';

        while ( res != 'n') {
        System.out.print("Digite a temperatura em Celsius: ");
        double C = sc.nextDouble();

        double F = 9.0 * C / 5.0 + 32.0;

        System.out.printf("Equivalente: %.1f%n", F);

        System.out.print("Deseja repetir y/n? ");
         res = sc.next().charAt(0);
        }

        sc.close();
    }
}
