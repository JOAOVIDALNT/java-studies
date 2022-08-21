package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        Account x = new Account(001, "João", 1000.0);
        Account y = new SavingsAccount(002, "Giulia", 1000.0, 0.05);

        x.withdraw(50.0);
        y.withdraw(50.0);
        /* Exemplo de polimorfismo pois uma única variável (Account) podem ter comportamentos diferentes*/

        System.out.println(x.getBalance());
        System.out.println(y.getBalance());



    }
}
