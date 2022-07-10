import java.util.Scanner;

public class Main {
    /* fazer um programa para ler tres numeros inteiros e printar o maior deles */
    public static void main(String[] args) { // funçao padrão de entrada
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os 3 números: ");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        
        int higher = max(a, b, c);
        
        showResult(higher);
        
        
        sc.close();
    }

    public static int max(int x, int y, int z) {
        
        int aux; // variável local

        if (x > y && x > z) {
            aux = x;
        } else if (y > x && y > z) {
            aux = y;
        } else {
            aux = z;
        }
        return aux;
    }
    
    public static void showResult(int value) { // void -> tipo que a função retorna é vazio
        System.out.println("Higher = " + value);
    }
}

// if ( a > b && a > c) {
//     System.out.println("Maior: " + a);
// } else if ( b > a && b > c) {
//     System.out.println("Maior: " + b);
// } else {
//     System.out.println("Maior: " + c);
// }