package br.dev.joaovidal.table.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "br.dev.joaovidal.table.controller")
public class BookControllerAdvice {

    @ResponseBody // define que retornará no corpo da resposta
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> bookNotFound(BookNotFoundException bookNotFoundException) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Book not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
