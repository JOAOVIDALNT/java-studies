package entities;

public final class SavingsAccount extends Account { // final impede que a classe seja extendida/herdada

    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }


    @Override // sobrepõe o método withdraw de account pois ele desconta 5.0 e a poupança nao descontará
    public final void withdraw(double amount) { // final evite que o método seja sobreposto em classes extendidas
        balance -= amount;
    } /* caso o nome da função esteja errado, o método override vai assinalar erro, pois para encontrar a função
    na classe super é preciso ser exato. */
}
