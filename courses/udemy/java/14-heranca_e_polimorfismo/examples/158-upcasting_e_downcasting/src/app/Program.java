package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        Account acc = new Account(001, "João", 700.00);

        BusinessAccount bacc =  new BusinessAccount(002, "Giulia", 500.00, 300.00);

        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(101, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(200, "Laura", 0.0, 0.01);

        // DOWNCASTING
//        BusinessAccount acc4 = acc2; - compilador não permite
        BusinessAccount acc4 = (BusinessAccount)acc2; // casting manual (inclui o tipo da subclasse)
        acc4.loan(100.0);

//        BusinessAccount acc5 = (BusinessAccount)acc3; // downcast não permitido
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("LOAN");
        }
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("UPDATE");
        }

    }
}
