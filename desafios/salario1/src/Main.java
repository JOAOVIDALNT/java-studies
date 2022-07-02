import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {


        Scanner sc = new Scanner(System.in);

        int id;
        int hours;
        double pay;

        id = sc.nextInt();
        hours = sc.nextInt();
        pay = sc.nextDouble();

        double calc = hours * pay;

        Locale.setDefault(Locale.US);

        System.out.println("NUMBER = " + id);
        System.out.printf("SALARY = R$%.2f%n", calc);


    }

}
