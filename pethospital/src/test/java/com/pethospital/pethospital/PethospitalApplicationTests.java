package com.pethospital.pethospital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pethospital.domain.Pet_member;
import com.pethospital.repository.Pet_member_Repository;

@SpringBootTest
class PethospitalApplicationTests {

	@Autowired
	Pet_member_Repository a;
	
	@Autowired
	BCryptPasswordEncoder e;
	
	@Test
	void contextLoads() {
		
		a.save(Pet_member.builder()
				.name("홍길동")
				.userId("user")
				.password(e.encode("abcd"))
				.nickname("nick")
				.email("a@b.com")
				.address("부산")
				.role("ROLE_MEMBER")
				.build());
		return ;
	}

}
