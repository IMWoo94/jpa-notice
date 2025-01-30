package com.example.jpa.exception;

public class NotFoundMember extends RuntimeException {
	public NotFoundMember(String message) {
		super(message);
	}
}
