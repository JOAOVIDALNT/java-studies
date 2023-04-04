package org.example;

public class Main {
    public static void main(String[] args) {
        Motorista motora = new Motorista(Strategy.BOLADO);
        System.out.println(motora.acelerar(10));

        motora.setStatus(Strategy.TRANQUILO);
        System.out.println(motora.acelerar(10));

    }
}