package entities;

public class CompanyPerson extends Person {

    private Integer employees;

    public CompanyPerson() {super();}

    public CompanyPerson(String name, Double anualIncome, Integer employees) {
        super(name, anualIncome);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public double taxCalc() {
        double result = 0.0;
        if (employees > 10) {
            result = anualIncome * 14.0 / 100;
        } else {
            result = anualIncome * 16.0 / 100;
        }
        return result;
    }
}
