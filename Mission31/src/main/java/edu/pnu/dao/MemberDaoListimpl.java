package edu.pnu.dao;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListimpl implements MemberInterface{
	List<MemberVO> list = new ArrayList<>();
	
	@Override
	// 데이터 추가
	public MemberVO addMember(MemberVO member) {
		MemberVO m = new MemberVO();
		list.add(member);
		m = list.get(member.getId() - 1);
		return m;
	}
	
	@Override
	// 특정 데이터 가져오기
	public MemberVO getMember(Integer id) {
		MemberVO m = new MemberVO();
		m = list.get(id - 1); 
		return m;
	}
	
	@Override
	// 데이터 전부 가져오기
	public List<MemberVO> getMembers() {
		return list;
	}
	
	@Override
	// 데이터 수정하기 
	public MemberVO updateMember(MemberVO member) {
		MemberVO m = new MemberVO();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == member.getId()) {
				list.remove(i);
				list.add(i, member);
				m = list.get(i);
				return m;
			}
		}
		return null;
	}
	
	@Override
	// 데이터 삭제하기
	public int deleteMember(Integer id) {
		// MemberVO m = new MemberVO();
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(id - 1) != null) {
//				
//				break;
//			}
//			return 1;
//		}
//		return 0;
		list.remove(id - 1);
		return 1;
	}
	
}
