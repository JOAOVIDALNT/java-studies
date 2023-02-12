/*
* Consegui concluir o desafio com certa facilidade, não usei os getters no core
* do programa mas creio que seja para manutenção, então não disponibilizei nenhum
* set do saldo da conta, ou seja: só é possível adicionar ou remover valores
* através de depositos e saques.
*
 */
package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);



        System.out.print("Enter account number: ");
        int id = sc.nextInt();

        System.out.print("Enter account holder: ");
        String name = sc.next();

        System.out.print("Is there an initial deposit? y/n: ");
        char init = sc.next().charAt(0);

        double balance = 0.0;
        if (init != 'n') {
            System.out.print("Enter initial deposit value: ");
             balance = sc.nextDouble();
        }
        Account account = new Account(name, id, balance);

        System.out.print("Account data: ");
        System.out.println(account);

        System.out.print("Enter a deposit value: ");
        double value = sc.nextDouble();
        account.addDeposit(value);

        System.out.print("Updated account data: ");
        System.out.println(account);

        System.out.print("Enter a withdraw value: ");
        value = sc.nextDouble();
        account.removeDeposit(value);

        System.out.print("Updated account data: ");
        System.out.println(account);


        sc.close();
    }


}

