package edu.pnu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BoardException.class)
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errores/boardError";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errores/globalError";
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public String UsernameNotFoundException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errores/loginError";
	}
	
	
	
}