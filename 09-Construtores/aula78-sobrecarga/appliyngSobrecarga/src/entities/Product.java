package entities;

public class Product {

    public String name;
    public double price;
    public int quantity;


    public Product(String name, double price, int quantity) {

        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    /* SOBRECARGA: disponibiliza mais de um método com parâmetros em comum
     * - é possivel manter o construtor padrão */
    public Product(String name, double price) {

        this.price = price;
        this.name = name;

    }

    public double totalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return name +
                ", $ " +
                String.format("%.2f", price) +
                ", " + quantity + " units, total: $ " +
                String.format("%.2f", totalValueInStock());
    }

}