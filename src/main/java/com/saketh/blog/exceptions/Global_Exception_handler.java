package com.saketh.blog.exceptions;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saketh.blog.payloads.Api_Response;

@RestControllerAdvice
public class Global_Exception_handler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Api_Response> resourceNotFoundExceptionHandler( ResourceNotFoundException ex)
	{
		String msg = ex.getMessage();
		Api_Response apiresponse = new Api_Response(msg,"wrong bro deko exception came");
		return new ResponseEntity<Api_Response>(apiresponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotFoundException(MethodArgumentNotValidException ex)
	{
		Map<String, String>  map=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldnameString = ((FieldError)error).getField();
			String ename = error.getDefaultMessage();
			map.put(fieldnameString, ename);
		});
		
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
	}
	

}
