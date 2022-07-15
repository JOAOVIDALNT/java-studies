package entities;

public class Product {

    private String name; // podem ser acessados atráves de métodos setters and getters ( getName & setName)
    private double price;
    private int quantity;


    public Product(String name, double price, int quantity) {

        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }


    public Product(String name, double price) {

        this.price = price;
        this.name = name;

    }

    // ENCAPSULAMETO: setName pode ser alterado e getName apenas retorna
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
        /* só muda a quantidade por meio de entrada e saida no estoque */
    }
    // ---------------------------------------------------





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