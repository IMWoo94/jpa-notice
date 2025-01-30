package com.example.jpa.exception;

public class NotFoundTeam extends RuntimeException {
	public NotFoundTeam(String message) {
		super(message);
	}
}
