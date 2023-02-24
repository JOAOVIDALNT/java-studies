package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Account account; //dentro do if

        System.out.print("Enter account number: ");
        int id = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        String name = sc.nextLine();
        /* CORREÇÃO: Nélio usa sc.nextLine para String, o primeiro é pra não bugar*/

        System.out.print("Is there an initial deposit? y/n: ");
        char init = sc.next().charAt(0);

        if (init == 'y') {
            System.out.print("Enter an initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(id, name, initialDeposit);
        } else {
            account = new Account(id, name);
        }
        /* CORREÇÃO: Nélio usa o conceito de sobrecarga para instanciar sim ou não um depósito incial
        * logo não é necessário sequer inciar um variavel com valor 0 no programa */


        System.out.println("Account data: ");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter an deposit value: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);


        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter an withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        /* CORREÇÃO: Nélio usa duas variáveis ao invés de apenas uma para depósito e saque, como eu fiz */


        System.out.println("Updated account data: ");
        System.out.println(account);


        sc.close();
    }
}
