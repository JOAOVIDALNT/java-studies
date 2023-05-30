package com.example.appchamadosjava.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super(String.format("Chamado com o id %d não encontrado", id));
    }
}
