package tw.chris.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MySystemExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public Object exceptHandle(Exception e) {
		String errorMsg1 = "Error:Exception";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg1);
	}
	
}
