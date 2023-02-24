package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

//        Account acc1 = new Account(101, "Pedro", 200.00); -> não instância pois a classe Account agora é abstrata
//        Account acc2 = new SavingsAccount(102, "Flavia", 200.00, 0.01);
//        Account acc3 = new BusinessAccount(103, "Mario", 200.00, 500.00);

        Account account = new SavingsAccount();
        List<Account> list = new ArrayList<>();

        list.add(new SavingsAccount(001, "João", 1000.00, 0.01));
        list.add(new BusinessAccount(002, "Giulia", 4000.00, 2000.00));
        list.add(new BusinessAccount(003, "João", 3000.00, 2000.00));
        list.add(new SavingsAccount(004, "Giulia", 800.00, 0.01));

        double sum = 0.0;

        for (Account acc : list) {
            sum += acc.getBalance();
        }

        System.out.printf("Total balance: %.2f%n", sum);

        for (Account acc : list) {
            acc.deposit(1000.0);
        }

        System.out.println("DEPOSIT");
        for (Account acc : list) {
            System.out.printf("Account %d: %.2f%n", acc.getNumber(), acc.getBalance());
        }


    }
}
