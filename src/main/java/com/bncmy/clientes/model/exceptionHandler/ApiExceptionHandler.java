package com.bncmy.clientes.model.exceptionHandler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bncmy.clientes.model.exception.CustomException;
import com.google.gson.Gson;

@RestControllerAdvice
public class ApiExceptionHandler {
	 @ExceptionHandler({NoHandlerFoundException.class})
	 public ResponseEntity<CustomException> handleNoHandlerFoundException(
	            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
		 CustomException custom =new CustomException("bancomaya/clientes/soporte", "Recurso no encontrado", LocalDateTime.now().toString());
		 System.out.println(new Gson().toJson(custom));
		 return new ResponseEntity<CustomException>(custom,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 
}
