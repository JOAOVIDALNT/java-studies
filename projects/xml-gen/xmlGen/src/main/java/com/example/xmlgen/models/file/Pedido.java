package com.example.xmlgen.models.file;

import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<Item> itens;

    public Pedido() {
    }

    public Pedido(Cliente cliente, List<Item> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
