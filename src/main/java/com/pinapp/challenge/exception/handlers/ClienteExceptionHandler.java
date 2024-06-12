package com.pinapp.challenge.exception.handlers;

import com.pinapp.challenge.exception.ClienteBadRequestException;
import com.pinapp.challenge.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteExceptionHandler {

    @ExceptionHandler(ClienteBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleTeamBadRequestException(ClienteBadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
