package util;

public class Calculator {

    public static final double PI = 3.14159; // final define uma constante
    // padrão de const caps lock



    public static double circumference(double radius) {
        return 2.0 * PI * radius;
    }

    public static double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}
