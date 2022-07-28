package application;

import entities.Car;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Car carro =  new Car();
        String modelo = null, color = null;
        double tanque = 0;

        Car car = new Car(modelo, color, tanque);

        do {
            System.out.print("How many liters to be added on the tank? ");
            double fuel = input.nextDouble();
            System.out.printf("%.2f%n", car.encherTanque(fuel));
        } while (car.getTanque() < 100);


        input.close();
    }
}
