
import java.util.Scanner;
import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
		
		//Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
	// INICIO M�TODOS UNIT�RIOS
//		String x;
//		x = sc.next();
		
//		int x;
//		x = sc.nextInt(); // especifica digitacao de valor inteiro
		
//		double x;
//		x = sc.nextDouble(); // Locale influencia no ponto: se digitar 4.5 gera um erro
							// mesmo em pt, se voc� digitar 4,5 o console retorna 4.5 basta usar %.2f%n no printf para retornar com virgula
		
//		char x;
//		x = sc.next().charAt(0); // L� o indice 0 do texto inserido
	// FIM DOS M�TODOS UNIT�RIOS
		
	// M�TODO INPUT ENTER INSERT
//		String x;
//		int y;
//		double q;
//		
//		x = sc.next();
//		y = sc.nextInt();
//		q = sc.nextDouble();
		
   	// PRINT M�TODO INPUT ENTER INSERT
//		System.out.println("Dados digitados:");
//		System.out.println(x);
//		System.out.println(y);
//		System.out.printf("%.2f%n", q);
		
		
	// PRINT DOS M�TODOS UNIT�RIOS
		//System.out.println("Voc� digitou : " + x);
		//System.out.printf("Voc� digitou %.2f%n", x); //imprime com a virgula. Se quiser usar o ponto � s� ativar o LocaleUS
		
		int x;
		String s1, s2, s3;
		
		x = sc.nextInt();
		sc.nextLine(); //resolve o problema de quebra de linha pendente pois o enter no int consome o pr�ximo nextLine
		s1 = sc.nextLine(); //nextLine l� a linha inteira e n�o s� uma palavra
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		
		System.out.println("Dados digitados:");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		sc.close();
		
		
	}
	
	
}