package com.arsyux.jblog.exception;

public class JBlogException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// RuntimeException이 아니라 Exception을 상속받아 작성해도 됨.
	// UserController의 getUser에서 검색 결과가 없을때 
	public JBlogException(String message) {
		super(message);
	}
}
