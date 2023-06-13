package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVOO;


public interface MemberInterface {

	List<MemberVOO> getMembers();
	
	MemberVOO getMember(Integer id);
	
	MemberVOO addMember(MemberVOO member);
	
	MemberVOO updateMember(MemberVOO member);
	
	int deleteMember(Integer id);
}
