import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);

    int id1;
    id1 = sc.nextInt();

    int pecas1;
    pecas1 = sc.nextInt();

    double value1;
    value1 = sc.nextDouble();

    double calc1 = value1 * pecas1;
    
    sc.nextLine();

    int id2;
    id2 = sc.nextInt();

    int pecas2;
    pecas2 = sc.nextInt();

    double value2;
    value2 = sc.nextDouble();

    double calc2 = value2 * pecas2;

    double result = calc1 + calc2;

    
    System.out.printf("VALOR A PAGAR: R$%.2f%n", result);


    }
}
