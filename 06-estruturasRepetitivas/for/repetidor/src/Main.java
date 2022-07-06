import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int soma = 0;

              // -> inicio: executa apenas da primeira vez 
             //  '      -> condição: V: executa e volta F: pula fora   
            //   '      '     .-> incremento: executa toda vez ao voltar
        for (int i=0; i < N ; i++) { 
            int x = sc.nextInt();
            soma += x;

        }

        System.out.println(soma);

        sc.close();
    }
}
