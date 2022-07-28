package application;

import entities.Car;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Car car =  new Car();
        String modelo = null, color = null;
        double tanque = 0, fuel = 0;

        Car carProperties = new Car(modelo, color, tanque);


        System.out.println("How many liters to be added in the tank?: ");
        fuel = input.nextDouble();
        car.encherTanque(fuel);

        System.out.println(car);

        input.close();
    }
}
