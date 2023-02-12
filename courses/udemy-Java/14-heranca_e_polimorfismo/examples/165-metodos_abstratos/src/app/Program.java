package app;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<Shape> shapeList = new ArrayList<>(); // permite instanciar classes que extendem

        for (int i = 1; i <= n; i++) {
            System.out.printf("Shape #%d data:", i);

            System.out.print("Rectangle or Circle (r/c)?: ");
            char x = sc.next().charAt(0);

            System.out.print("Color (RED/GREEN/BLUE): ");
            Color color = Color.valueOf(sc.next()); // enum

            if (x == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();

                System.out.print("Height: ");
                double height = sc.nextDouble();

                shapeList.add(new Rectangle(color, width, height)); // upcasting para shape
            } else if (x == 'c') {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                shapeList.add(new Circle(color, radius)); // upcasting para shape
            } else {
                System.out.println("Invalid character");
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS: ");

        for (Shape shape : shapeList) {
            System.out.println(String.format("%.2f", shape.area()));
        }



        sc.close();
    }
}
