package edu.pnu.Controller;

import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.MemberVOOService;

// 웹브라우저에서 요청한 데이터를 받아서 Service를 호출한다.
@RestController
public class MemberVOOController {
	MemberVOOService ser;

	public MemberVOOController() {
		ser = new MemberVOOService();
	}
	
	// 데이터 추가하기
	@GetMapping("/member/")
	public 
}
