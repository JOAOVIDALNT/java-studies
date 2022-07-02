import java.util.Scanner;

public class Main {
    

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        double value = sc.nextDouble();

        if ( value >= 0 && value <= 25) {
            System.out.println("INTERVALO: [0,25]");
        }
        else if ( value > 25 && value <= 50) {
            System.out.println("INTERVALO: [25,50]");
        }
        
        else if ( value > 50 && value <= 75) {
            System.out.println("INTERVALO: [50,75]");
        }
        
        else if ( value > 75 && value <= 100) {
            System.out.println("INTERVALO: [75,100]");
        }
        else {
            System.out.println("FORA DE INTERVALO");
        }




        sc.close();


    }
}
