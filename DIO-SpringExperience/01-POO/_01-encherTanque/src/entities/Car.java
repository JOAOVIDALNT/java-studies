package entities;

public class Car {

    private String modelo;
    private String color;
    private double tanque;

    public double encherTanque(double fuel) {
            return tanque += fuel;

    }


    public Car() {

    }

    public Car(String modelo, String color, double tanque) {
        this.modelo = modelo;
        this.color = color;
        this.tanque = tanque;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTanque() {
        return tanque;
    }

    public void setTanque(double tanque) {
        this.tanque = tanque;
    }

    @Override
    public String toString() {
        return "total liters added: " + getTanque() + ", thank you and drive carefully!";
    }
}
