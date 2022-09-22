package app;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Date (dd/mm/yyyy): ");
        Date date = sdf.parse(sc.next());

        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(date, number, totalValue); // instancia o contrato

        System.out.print("Enter the number of installments: ");
        int n = sc.nextInt(); // define o numero de parcelas

        ContractService contractService = new ContractService(new PaypalService()); // aplica a classe paypalService através da interface onlinePaymentService (que é o arumento na classe ContractService)

        contractService.processContract(contract, n);

        System.out.println("Installments:");

        for (Installment x : contract.getInstallments()) {
            System.out.println(x);
        }

        sc.close();
    }
}
