package com.example.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
	
	public ErrorMessage dataNotFound(final DataNotFoundException exception,final HttpServletRequest request) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		
		return error;
}
}
