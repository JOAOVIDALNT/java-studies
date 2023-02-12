package entities;

public class Product {

    public String name;
    public double price;
    public int quantity;

    /* Construtor: não tem método de retorno, inicia logo na instanciação do objeto no programa. É normalmente posicionado depois dos atributos e antes dos métodos */
    public Product(String name, double price, int quantity) {
        /* parâmetros poderiam ter outros nomes */

        this.price = price;
        this.quantity = quantity;
        this.name = name;
        /* referência ao atributo do objeto e não ao parâmetro do método */
    }

    public double totalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity; // this é uma auto referência para o objeto e não para o parâmetro
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