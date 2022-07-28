package entities;

public class Triangle {

    public double a;
    public double b;
    public double c;

    public double area() { // não recebe parâmetro pois a, b e c são os unicos necessários
         double p = (a + b + c) / 2.0;
         double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
         return result;
         // ou apenas: return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    }

