package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        Account acc1 = new Account(23, "Lebron", 1000.0);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance()); // 795.0 pois desconta o valor de saque 5.0;

        Account acc2 = new SavingsAccount(24, "Bryant", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance()); // 800.0 pois o override subscreveu a função withdraw em savings

        Account acc3 = new BusinessAccount(77, "Doncic", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance()); // 793.0 pois o override reutiliza a função e desconta +2



    }
}
