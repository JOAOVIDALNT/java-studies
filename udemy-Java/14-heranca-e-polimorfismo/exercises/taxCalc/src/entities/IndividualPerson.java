package entities;

public class IndividualPerson extends Person {

    private Double healthExpend;

    public IndividualPerson() { super(); }

    public IndividualPerson(String name, Double anualIncome, Double healthExpend) {
        super(name, anualIncome);
        this.healthExpend = healthExpend;
    }

    public Double getHealthExpend() {
        return healthExpend;
    }

    public void setHealthExpend(Double healthExpend) {
        this.healthExpend = healthExpend;
    }

    @Override
    public double taxCalc() {
        double result = 0.0;
        if (anualIncome < 20000.00) {
            result = anualIncome * 15.0 / 100.0;
        } else if (anualIncome > 20000.00) {
            result = anualIncome * 25.0 / 100.0;
        }
        if (healthExpend != 0.0) {
            result -= healthExpend * 50.0 / 100.0;
        }
        return result;
    }
}
