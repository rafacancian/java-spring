package com.javaspring.company.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

public class ControllerException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException exception, final WebRequest request) {
        final EntityNotFoundException entityNotFoundException = (EntityNotFoundException) exception;
        return handleExceptionInternal(exception, buildMessageError(entityNotFoundException.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private ErrorMessage buildMessageError(String message) {
        return ErrorMessage.builder().type("Error").message(message).build();
    }


}
