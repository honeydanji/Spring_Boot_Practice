package edu.pnu.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.Service.TestService1;
import edu.pnu.Service.TestService2;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	
	
	private final TestService1 test1;
	private final TestService2 test2;
	
	public String home() {
		return "Home";
	}
	
	@GetMapping()
	public String test() {
		return test1.test();
	}
	
}
