package com.MultiSearch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private CustomResponse customErrorDetails;
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<CustomResponse> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, WebRequest request) {

        CustomResponse errorDetails = new CustomResponse(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
