package com.example.appchamadosjava.exceptions;

public class NoTicketsRegisteredException extends RuntimeException {
    public NoTicketsRegisteredException(String ex) {
        super(ex);
    }
}
