package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {
		// 본문이 구현되지 않은 메소드
		// 해당 인터페이스를 상속받는 하위클래스에서 메소드 본문을 구현 해줘야한다.
		
		List<MemberVO> getMembers();
		
		MemberVO getMember(Integer id);
		
		MemberVO addMember(MemberVO member);
		
		MemberVO updateMember(MemberVO member);
		
		int deleteMember(Integer id);
}
