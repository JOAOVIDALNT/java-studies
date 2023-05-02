package com.example.appchamadosjava.exceptions.handler1;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super(String.format("Chamado com o id %d não encontrado", id));
    }
}
