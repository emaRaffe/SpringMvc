package com.springrestmvc.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springrestmvc.exception.RealmException;
import com.springrestmvc.exception.RealmNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RealmException.class })
    protected ResponseEntity<Object> handleRealmNameException(final RealmException ex, final WebRequest request) {
	final ErrorDetails errorDetails = new ErrorDetails("InvalidRealmName");
	return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException ex,
	    final WebRequest request) {
	final ErrorDetails errorDetails = new ErrorDetails("DuplicateRealmName");
	return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { RealmNotFoundException.class })
    protected ResponseEntity<Object> handleRealmNotFoundException(final RealmNotFoundException ex,
	    final WebRequest request) {
	final ErrorDetails errorDetails = new ErrorDetails("RealmNotFound");
	return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleIllegalArgumentException(final IllegalArgumentException ex,
	    final WebRequest request) {
	final ErrorDetails errorDetails = new ErrorDetails("InvalidArgument");
	return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}