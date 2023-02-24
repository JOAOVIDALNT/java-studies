package entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super(); // repete a lógica que for incluida no construtor padrão da classe Account
    }

    public BusinessAccount(Integer number, String name, Double balance, Double loanLimit) {
        super(number, name, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0; // balance precisa ser protected ao invés de private
        }
    }
}
