package entities;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // ======================================================================================================

    public void SalaryIncrease(double percentage) {
        salary += salary * percentage / 100;
    }

    @Override
    public String toString() {
        return String.format(id + ", " + name + ", " + String.format("%.2f", salary));
    }
}
