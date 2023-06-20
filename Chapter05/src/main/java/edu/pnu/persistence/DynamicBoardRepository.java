package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import edu.pnu.domain.Board;

public interface DynamicBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
	// JpaRepository : 상속을 받게 되면 해당 클래스는 JAP에서 BEAN을 알아서 생성해준다. 즉 @Repository가 필요없다.
}


