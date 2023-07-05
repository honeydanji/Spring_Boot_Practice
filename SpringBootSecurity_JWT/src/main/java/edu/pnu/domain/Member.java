package edu.pnu.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // JPA 기본주석 : Member가 Table이라는 것을 증명한다. 데이터베이스에서 관리하고 유지를 할 수 있다.
public class Member {

	@Id
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList(role);
		// createAuthorityList(role) : role 변수를 기반으로 권한 목록을 생성한다. 
	}
}
