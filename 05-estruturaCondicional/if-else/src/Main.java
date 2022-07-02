import java.util.Scanner;

public class Main {


    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour;

        System.out.println("Que horas são?");
        hour = sc.nextInt();

        if (hour < 12) {
            System.out.println("Bom dia");
        }
        else if (hour > 18) { 
            System.out.println("Boa noite");
        } 
        else {
            System.out.println("Boa tarde");
        }

        sc.close();

    }
    
}
