package com.example.appchamadosjava.exceptions;

import com.example.appchamadosjava.exceptions.ticketExeptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice(basePackages = "com.example.appchamadosjava.controllers")
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(InvalidNameException.class)
//    public ResponseEntity<MessageExceptionHandler> invalidName(InvalidNameException ex) {
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.BAD_REQUEST.value(), "Nome inválido");
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(InvalidDescriptionException.class)
//    public ResponseEntity<MessageExceptionHandler> invalidDescription(InvalidDescriptionException ex) {
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.BAD_REQUEST.value(), "Descreva o problema");
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(TicketNotFoundException.class)
//    public ResponseEntity<MessageExceptionHandler> ticketNotFound(TicketNotFoundException ex) {
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.NOT_FOUND.value(), "Nenhum chamado encontrado com o id informado");
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(UnableToReviewException.class)
//    public ResponseEntity<MessageExceptionHandler> unableToReview(UnableToReviewException ex) {
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.BAD_REQUEST.value(), "Só é possível avaliar problemas resolvidos");
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(UnableToUpdateException.class)
//    public ResponseEntity<MessageExceptionHandler> unableToUpdate(UnableToUpdateException ex) {
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.BAD_REQUEST.value(), "Não é possível alterar o status de chamados finalizados");
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(Exception.class) // trata as exceções mais genéricas
    public final ResponseEntity<MessageExceptionHandler> handleAllExceptions(Exception ex) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), "Erro: " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }






//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//
//        StringBuilder sb = new StringBuilder("Os campos seguintes não podem ser nulos:");
//        for(FieldError fieldError : fieldErrors) {
//            sb.append(" | ");
//            sb.append(fieldError.getField());
//        }
//
//        MessageExceptionHandler error = new MessageExceptionHandler(
//                new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString());
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
