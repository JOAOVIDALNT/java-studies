package entities;

public class Account {

    int id;
    String name;
    double balance;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // CORREÇÃO: Nélio cria dois constructors, um com o balance e outro sem.
    public Account(int id, String name, double initialDeposit) {
        this.id = id;
        this.name = name;
        deposit(initialDeposit); /* CORREÇÃO: para o depósito incial, o nélio chama a função de depósito e
         passa o valor como argumento (é uma regra de negócio, pois se a regra de depósito mudar
         precisamos mudar apenas a função de depósito).
        */
    }

    public int getId() {
        return id;
    }

    // CORREÇÃO: Nélio também oculta o setId, eu ocultei apenas o setBalance

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
            balance += amount;
    }
    // CORREÇÃO: Nélio usa termos melhores, como deposit, withdraw e amount
    public void withdraw(double amount) {
        balance -= amount + 5.0; // CORREÇÃO: após o '-=', basta usar '+' para subtrair outro valor

    }

    public String toString() {
        return "Account: " + id + ", Holder: " + name + ", Balance: $ " + String.format("%.2f", balance);
        /* CORREÇÃO: Nélio usa String format (escolhi não usar por opção própria) */
    }

}