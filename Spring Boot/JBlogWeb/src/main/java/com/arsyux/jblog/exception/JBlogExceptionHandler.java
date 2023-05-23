package com.arsyux.jblog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class JBlogExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String globalExceptionHandler(Exception e) {
		// globalExceptionHandler 메소드는 애플리케이션에서 발생된 모든 예외를 받아서 HTML 메시지로 반환한다.
		return "<h1>"+e.getMessage()+"</h1>";
	}

}
