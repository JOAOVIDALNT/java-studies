package app;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Program {
    public static void main(String[] args) {
        ConcretePrinter p = new ConcretePrinter("1301");
        p.processDoc("My Letter");
        p.print("My Letter");

        ConcreteScanner s = new ConcreteScanner("0409");
        s.processDoc("My Email");
        System.out.println("Scan result: " + s.scan());

        ComboDevice c = new ComboDevice("1101");
        c.processDoc("My dissertation");
        c.print("My dissertation");
        System.out.println("Scan result: " + c.scan());
    }
}
