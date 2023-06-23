package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.exception.BoardNotFoundException;
import edu.pnu.exception.GlobalExceptionHandler;
import edu.pnu.exception.UsernameNotFoundException;
import edu.pnu.service.MemberService;


@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login") // 반화타입이 없기 때문에 실행하면 login.html을 호출한다.
	public void loginView() {
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		//GlobalExceptionHandler error = new GlobalExceptionHandler();
		
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
//			if(findMember.getName() == null) return error.UsernameNotFoundException(null, model);
//			return "redirect:login";
			throw new UsernameNotFoundException("사용자가 없습니다.");
		}
	}
	
	@GetMapping("/logout")
	   public String logout(SessionStatus status) {
	      status.setComplete();
	      return "redirect:index.html";
	}
}
