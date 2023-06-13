package edu.pnu.service;

import edu.pnu.dao.MemberInterface;

// Controller에서 요청한 데이터를 Dao로 넘겨준다.
public class MemberVOOService {
	
	MemberInterface dao;
	
	public MemberVOOService() {
		dao = new MemberDAOListimpl();
	}
	
	
}
