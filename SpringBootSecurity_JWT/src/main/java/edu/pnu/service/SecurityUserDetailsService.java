package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memRepo; // JPA상속받은 클래스를 통해 요청한 데이터를 DB에서 불러올 수 있다. 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memRepo.findById(username).orElseThrow(() -> 
				new UsernameNotFoundException("Not Found!"));
		// username이 존재하지 않으면 "NOT Found" 를 리턴한다. (아이디가 없을 경우)
		// .orElseThrow를 쓰지 않고 조건문으로 직접 로직을 구현해도 된다. 
		// 대신 member는 객체(Object)기 때문에 객체로 저장해야한다. 
		
		return new User(member.getUsername(), member.getPassword(), member.getAuthorities());
	}

}
