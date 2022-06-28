import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
		
		String product1 = "Computer";
		String product2 = "Office desk";
		
		int age = 30;
		int code = 5290;
		char gender = 'M';
		
		double price1 = 2100.0;
		double price2 = 650.50;
		double measure = 53.234567;
		
// correção com comentários
		
		System.out.println("Products");
		
		System.out.println(product1 + " wich price is $ " + price1);
//		System.out.printf("%s wich price is $ %.2f%n", product1, price1);
		
		System.out.println(product2 + " wich price is $ " + price2);
//		System.out.printf("%s wich price is $ %.2f%n", product2, price2);
		
		System.out.println("");
//		System.out.println();
		
		System.out.println("Record: " + age + " years old, code " + code + " and gender: " + gender);
// 		System.out.printf("Record: %d years old, code %d and gender: %c%n", age, code, gender);
		
		System.out.println("");
//		System.out.println();
		
		System.out.println("Measure with eight decimal places: " + measure);
// 		System.out.printf("Measure with eight decimal places: %.8f%n", measure);
		
		System.out.printf("Rouded (three decimal places): %.3f%n", measure); //correto
		
		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f%n", measure); //correto
		
		
	}
}