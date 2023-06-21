package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	
	// 리턴갑이 존재하면 작성한대로 리턴한다
	@GetMapping("/home")
	public String home() {
		// ==> [/WEB-INF/board/home.jsp]
		return "home";
	}
	
	
	// ==> [/WEB-INF/board/home1.jsp]
	// 리턴타입이 void면 maaping주소가 반환된다. = "home1" 반환
	@GetMapping("/home1")
	public void home1() {
	}
	
	
	@GetMapping("/model")
	public String model(Model model) {
		model.addAttribute("data", "홍길동");
		return "model";
	}
}
