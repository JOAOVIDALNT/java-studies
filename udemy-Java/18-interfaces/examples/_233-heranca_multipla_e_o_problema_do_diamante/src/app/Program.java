package app;

import devices.Printer;
import devices.Scanner;

public class Program {
    public static void main(String[] args) {
        Printer p = new Printer("1301");
        p.processDoc("My Letter");
        p.print("My Letter");

        Scanner s = new Scanner("0409");
        s.processDoc("My Email");
        System.out.println("Scan result: " + s.scan());
    }
}
