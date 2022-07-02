import java.util.Scanner;

public class Main {
    


   
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int initHour, finalHour;
        
        initHour = sc.nextInt();
        finalHour = sc.nextInt();
        
        // ou 
        // int initHour = sc.nextInt();
        // int finalHour = sc.nextInt();

        int duration;

        if (initHour < finalHour) {
            duration = finalHour - initHour;
        }
        else {
            duration = 24 - initHour + finalHour;
        }

        System.out.println("O JOGO DUROU " + duration + " HORA(S)");

        sc.close();
    }
}
