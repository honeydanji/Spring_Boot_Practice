package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDaoListimpl;
import edu.pnu.dao.MemberDaoSqlimpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberVOService {

	MemberInterface dao;
	
	public MemberVOService() {
		//dao = new MemberDaoListimpl();
		dao = new MemberDaoSqlimpl();
	}
	
	// 데이터 추가하기
	public MemberVO addMember(MemberVO member) {
		return dao.addMember(member);
	}
	
	// 특정 데이터 가져오기		
	public MemberVO getMember(Integer id) {
		return dao.getMember(id);

	}
	
	// 데이터 전부 가져오기
	public List<MemberVO> getMembers() {
		return dao.getMembers();
	
	}
	
	// 데이터 수정하기
	public MemberVO updateMember(MemberVO member) {
		return dao.updateMember(member);
		
	}
	
	// 데이터 삭제하기
	public int deleteMember(Integer id) {
		return dao.deleteMember(id);
		
	}
	
}
