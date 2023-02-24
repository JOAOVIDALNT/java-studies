package entities;

import entities.enums.Color;

public abstract class Shape { // classes com métodos abstratos precisam ser abstratas

    private Color color;

    public Shape() {}

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double area(); // método abstrato
}
