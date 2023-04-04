package entities;

public final class ImportedProduct extends Product {
    private Double customsFree;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double customsFree) {
        this.customsFree = customsFree;
    }

    public double totalPrice() {
        return price += customsFree;
    }

    @Override
    public String priceTag() {
        return name + " R$" + totalPrice() + String.format(" (Customs free: %.2f)", customsFree);
    }
}
