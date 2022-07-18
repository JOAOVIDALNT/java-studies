package entities;

public class Account {

    private String name;
    private int id;
    private double balance;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }



    public Account() {

    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }


    public void addDeposit(double deposit) {
        this.balance += deposit;
    }

    public void removeDeposit(double deposit) {
        this.balance -= deposit;
        this.balance -= 5;
    }


    public String toString() {
        return "Account " + id + ", Holder: " + name + ", Balance: " + balance;
    }


}


