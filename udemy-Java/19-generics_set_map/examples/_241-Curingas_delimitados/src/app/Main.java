package app;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(3.0));
        myCircles.add(new Circle(4.0));


        System.out.println("Total area: " + totalArea(myCircles));
    }

    public static double totalArea(List<? extends Shape> list) { /* pode ser de Shape ou de qualquer tipo que extende shape -> permite totalArea(myCircles) */
//        list.add(new Rectangle(3.0, 4.0)); -> não permite adicionar por conta do tipo curinga
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}
