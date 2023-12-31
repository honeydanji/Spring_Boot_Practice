package edu.pnu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberVOService;

@RestController
public class MemberVOController {
	
	@Autowired
	MemberVOService ser;
	
//	public MemberVOController() {
//		 ser = new MemberVOService();
//	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		return ser.addMember(member);
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return ser.getMember(id);
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return ser.getMembers();
	}
	
	@PutMapping("/member/")
	public MemberVO updateMember(MemberVO member) {
		return ser.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public int deleteMember(@PathVariable Integer id) {
		return ser.deleteMember(id);
	}
	
	
}

