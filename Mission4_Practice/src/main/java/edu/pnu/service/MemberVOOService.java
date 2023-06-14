package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDaoListimpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVOO;

// Controller에서 요청한 데이터를 Dao로 넘겨준다.
public class MemberVOOService {
	
	MemberInterface dao;
	
	public MemberVOOService() {
		dao = new MemberDaoListimpl();
	}
	
	// 데이터 추가하기
	public MemberVOO addMember(MemberVOO member) {
		// Controller에서 전달 받은 데이터를 dao로 보낸다.
		return dao.addMember(member);
	}
	
	// 데이터 전부 가져오기
	public List<MemberVOO> getMember(){
		return dao.getMembers();
	}
	
	// 특정 데이터 가져오기
	public MemberVOO getMember(Integer id) {
		return dao.getMember(id);
	}
	
	// 데이터 수정하기
	public MemberVOO updateMember(MemberVOO member) {
		return dao.updateMember(member);
	}
	
	// 데이터 삭제하기
	public int deleteMember(Integer id) {
		return dao.deleteMember(id);
	}
	
}
