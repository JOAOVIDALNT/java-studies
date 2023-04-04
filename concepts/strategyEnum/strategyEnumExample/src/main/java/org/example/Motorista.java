package org.example;

public class Motorista {

    private Strategy status;
    private double velocidade;

    public Motorista(Strategy status) {
        this.status = status;
    }

    public double acelerar(double velocidade) {
        return this.status.velocidadeAtual(velocidade);
    }

    public Strategy getStatus() {
        return status;
    }

    public void setStatus(Strategy status) {
        this.status = status;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
}
