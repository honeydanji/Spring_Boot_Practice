package edu.pnu.exception;

public class UsernameNotFoundException extends RuntimeException{

	public UsernameNotFoundException(String message) {
		super(message);
	}
}
