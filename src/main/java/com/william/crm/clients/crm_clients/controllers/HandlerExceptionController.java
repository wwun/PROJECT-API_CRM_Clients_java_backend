package com.william.crm.clients.crm_clients.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.william.crm.clients.crm_clients.dtos.HandlerExceptionDto;
import com.william.crm.clients.crm_clients.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.Date;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({UserNotFoundException.class})
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //no es necesario porqe ya se está devolviendo un ResponseEntity
    public ResponseEntity<?> userNotFoundException(Exception ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setDate(new Date());
        handlerExceptionDto.setTypeOfError("User doesn't exist");
        handlerExceptionDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerExceptionDto.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerExceptionDto);
    }

    @ExceptionHandler({SQLInvalidAuthorizationSpecException.class, CannotCreateTransactionException.class})
    public ResponseEntity<?> invalidAuthorization(SQLException ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setDate(new Date());
        handlerExceptionDto.setStatus(HttpStatus.UNAUTHORIZED.value());
        handlerExceptionDto.setTypeOfError("Problem with database");
        handlerExceptionDto.setMessage(ex.getMessage() + ex.getErrorCode());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(handlerExceptionDto);
    }

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<?> invalidNumberConversion(Exception ex){
        HandlerExceptionDto handlerException = new HandlerExceptionDto();
        handlerException.setDate(new Date());
        handlerException.setTypeOfError("There was an issue to convert to number");
        handlerException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerException.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerException);
    }
    
}
