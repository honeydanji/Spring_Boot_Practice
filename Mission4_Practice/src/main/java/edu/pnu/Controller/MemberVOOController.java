package edu.pnu.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVOO;
import edu.pnu.service.MemberVOOService;

// 웹브라우저에서 요청한 데이터를 받아서 Service를 호출한다.
@RestController
public class MemberVOOController {
	MemberVOOService ser;

	public MemberVOOController() {
		// MemberVOOService 객체를 생성해야 메소드 호출이 가능하다.
		ser = new MemberVOOService();
	}
	
	// 데이터 추가하기
	@PostMapping("/member/")
	public MemberVOO addMember(MemberVOO member) {
		// 도메인을 통해 값을 전달받아 Service로 보내준다.
		return ser.addMember(member);
	}
	
	// 데이터 전부 가져오기
	@GetMapping("/member")
	public List<MemberVOO> getMember(){
		return ser.getMember();
	}
	
	// 특정 데이터 가져오기
	@GetMapping("/member/{id}")
	public MemberVOO getMember(Integer id) {
		return ser.getMember(id);
	}
	
	// 데이터 수정하기
	@PutMapping("/member/")
	public MemberVOO updateMember(MemberVOO member) {
		return ser.updateMember(member);
	}
	
	// 데이터 삭제하기
	@DeleteMapping("/member/{id}")
	public int deleteMember(Integer id) {
		return ser.deleteMember(id);
	}
	
	
}
