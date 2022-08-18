package app;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        List<Product> productList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            System.out.printf("Product %d data:\n", i);
            System.out.print("Common, used or imported (c/u/i)?: ");
            char x = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (x == 'c') {
                productList.add(new Product(name, price));
            } else if (x == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                productList.add(new UsedProduct(name, price, date));
            } else if (x == 'i') {
                System.out.print("Customs free: ");
                double customsFree = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customsFree));
            } else {
                System.out.println("Product type not specified");
            }

        }

        System.out.println("PRICE TAGS:");
        for (Product product : productList) {
            System.out.println(product.priceTag());
        }




        sc.close();
    }
}
