package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.pnu.service.MemberVOService;

@Configuration
public class MemberConfig {

	@Bean
	public MemberVOService memberService() {
		return new MemberVOService();
	}
	
}

// @Bean:
// 1. 외부클래스를 사용하게 하는 방법 중에 하나
// 2. 주석을 지정한 메소드가 반환하는 데이터를 빈(객체)을 생성한다. 만들어진 빈은 spring 에서 관리할 수 있다.
// 3. 외부에서 빈에 들어있는 객체에 접근하기 쉽게 만든다.
// 4. 스테레오 타입 주석이랑 기능이 같다. 위와 같은 주석을 사용하는 이유는
// 5. 특정 클래스의 데이터를 숨기기 위해서는 @Bean을 사용하면 된다.
// 6. 즉 데이터를 숨겨놓는 게 목적이다.

// @Configuration(메타주석)
// @Bean이 존재한다는 사실을 spring에게 알려주는 역할.
// 그렇다 할만한 기능은 없다.