import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for ( int i = 1; i <= n; i++) {

            int qd = i * i;
            int cb = i * qd;
            
            System.out.print(i);
            System.out.print(qd);
            System.out.println(cb);
        }


        sc.close();
    }
}
