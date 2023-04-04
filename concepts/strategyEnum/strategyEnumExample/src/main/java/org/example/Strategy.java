package org.example;

public enum Strategy {

    TRANQUILO {
        @Override
        double velocidadeAtual(double velocidade) {
            return velocidade * 1;
        }
    },
    BOLADO {
        @Override
        double velocidadeAtual(double velocidade) {
            return velocidade * 2.0;
        }
    };





    abstract double velocidadeAtual(double velocidade);
}
