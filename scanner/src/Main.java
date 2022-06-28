
import java.util.Scanner;
import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
		
		//Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		//String x;
		//x = sc.next();
		
		//int x;
		//x = sc.nextInt(); // especifica digitacao de valor inteiro
		
		//double x;
		//x = sc.nextDouble(); // Locale influencia no ponto: se digitar 4.5 gera um erro
							  // mesmo em pt, se você digitar 4,5 o console retorna 4.5 basta usar %.2f%n no printf para retornar com virgula
		
		//char x;
		//x = sc.next().charAt(0);
		
		String x;
		int y;
		double q;
		
		x = sc.next();
		y = sc.nextInt();
		q = sc.nextDouble();
	
		System.out.println("Dados digitados:");
		System.out.println(x);
		System.out.println(y);
		System.out.printf("%.2f%n", q);
		
		
		//System.out.println("Você digitou : " + x);
		//System.out.printf("Você digitou %.2f%n", x); //imprime com a virgula. Se quiser usar o ponto é só ativar o LocaleUS
		 
		
		sc.close();
		
		
	}
	
	
}