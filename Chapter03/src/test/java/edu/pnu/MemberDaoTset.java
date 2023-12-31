package edu.pnu;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberDaoTset {

	MemberDao memberDao = new MemberDao();
	
	@Test
	@Order(1)
	public void insertMemberTest() {
		
		
		for(int i = 1; i <= 10; i++) {
			// 방법 1 : Builder를 이용한 방법
//			memberDao.insertMember(
//					
//					Member.builder()
//							.name("name" + i)
//							.age(20 + i)
//							.nickname("nickname" + i)
//							.build());
			
			
			// 방법 2 : 기본 생성자를 이용한 방법
			Member m = new Member();
			m.setName("name" + i);
			m.setAge(20 + i);
			m.setNickname("nickname" + i);
			memberDao.insertMember(m);
			
			
			// 방법 3 : 파라미터가 필요한 생성자를 이용한 방법
			//memberDao.insertMember(new Member(-1L, "name" +i , 20 + i,"nickname" + i));
			
		}
	}
	
	@Test
	@Order(2)
	public void selectAllMemberTest() {
		List<Member> list = memberDao.getMembers();
		
		for(Member a : list) {
			System.out.println(a);
		}
	}
}
