package edu.pnu.dao;
// Service에서 요청한 데이터 값 보내주는 실행 코드 작성하기

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVOO;

public class MemberDaoListimpl implements MemberInterface{
	List<MemberVOO> list = new ArrayList<>();
	
	// 데이터 추가하기
	@Override
	public MemberVOO addMember(MemberVOO member) {
		// dao를 통해 전달받은 값을 MemberVOO에 저장하고 다시 저장한 값을 불러와서 Service > Controller > 도메인으로 반환해준다.
		MemberVOO m = new MemberVOO();
		
		m.setId(list.size() + 1);
		m.setPass(member.getPass());
		m.setName(member.getName());
		m.setRegidate(new Date());
		list.add(m);
		return m;
	}
	
	// 데이터 전부 가져오기
	@Override
	public List<MemberVOO> getMembers() {
		return list;
	}

	// 특정 데이터 가져오기
	@Override
	public MemberVOO getMember(Integer id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		return null;
	}
	
	// 데이터 수정하기
	@Override
	public MemberVOO updateMember(MemberVOO member) {
		MemberVOO m = new MemberVOO();
	
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == member.getId()) {
				m.setPass(member.getPass());
				m.setName(member.getName());
				return list.get(i);
			}
		}
		return null;
	}

	// 데이터 삭제하기
	@Override
	public int deleteMember(Integer id) {
		for(MemberVOO m : list) {
			if(m.getId() == id) {
				// 원래는 remove(int index) 즉 인덱스를 인자로 받는다.
				// 하지만 확장 for문에서는 리스트안에 있는 값 자체를 인자로 받아서
				// 해당하는 값을 지워주는 역할도 할 수 있다.. 
				list.remove(m); 
				return 1;
			}
		}
		return -1;
	}
}

/*
 * list = {객체배열}
 * list.remove(객체)
 * 
 * list = {2, 4, 6, 8}
 * list.remove(int index) or list.remove(2) 무엇이 맞을까?
 * 내가 알고있떤 지식은 무조건 index에 해당하는 요소를 지워주는 줄 알고 있었는데
 * 위에서는 해당하는 값자체를 지워버리니깐 의문이 남는다? 그럼 list안에 정수배열로 이루어져있으면
 * 뭐가 우선일까?
 * 
 * 
 * */
