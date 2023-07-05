package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	// JpaRepository DB에 접근하는 코드를 따로 작성할 필요가 없어졌다.
	// 만약 JpaRepository가 없다면 DAO를 따로 작성해줘야한다.
}
