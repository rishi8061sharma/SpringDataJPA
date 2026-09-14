package com.hwlmsp.springboot;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.context.request.WebRequest; 
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler; 

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

/*	Case: 
 * 1. all the exception are commented then every exception call  these method
 * 2. CustomerIDNotFoundException instead is Exception.class write then ClassIdFoundException 
 * check in every method then matching is not found then run the Exception.class methods
 * 
 * @ExceptionHandler({ Exception.class  }) 
	public ResponseEntity<MyErrorMessage> handleCidNotFound() { 
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror("Customer Id is Not Available"); 
		errMsg.setMystatus(HttpStatus.NOT_FOUND.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND); 
	}
	*/
	
	
/* Can we make one method to handle all type of exception	? 
 *   Yes , we can If two exception have same logic so we can it but practically is not possible
 * @ExceptionHandler({ CustomerIDNotFoundException.class, InvalidPhoneNumberException.class  }) 
	public ResponseEntity<MyErrorMessage> handleCidNotFound() { 
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror("Customer Id is Not Available"); 
		errMsg.setMystatus(HttpStatus.NOT_FOUND.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND); 
	}
	*/
	
	@ExceptionHandler({ CustomerIDNotFoundException.class }) 
	public ResponseEntity<MyErrorMessage> handleCidNotFound() { 
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror("Customer Id is Not Available"); 
		errMsg.setMystatus(HttpStatus.NOT_FOUND.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND); 
	} 


	@ExceptionHandler({ InvalidPhoneNumberException.class }) 
	public ResponseEntity<MyErrorMessage> handlePhoneNotFound(RuntimeException ex, 
			WebRequest request) { 
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror(" Phone Number Not Found"); 
		errMsg.setMystatus(HttpStatus.FORBIDDEN.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.FORBIDDEN); 
	} 

	@ExceptionHandler({ CityNotFoundException.class }) 
	public ResponseEntity<MyErrorMessage> handleCityNotFound(RuntimeException ex, WebRequest 
			request) { 
		System.out.println(" inside handleCityNotFound method ");
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror(" No Customers with given City"); 
		errMsg.setMystatus(HttpStatus.BAD_REQUEST.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST); 
	} 
}
