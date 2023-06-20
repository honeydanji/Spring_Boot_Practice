package edu.pnu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;

	private void test(String searchCondition, String searchKeyword) {
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			// select b from Board b where title like '%'||:searchKeyword||'%'
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			// select b from Board b where content like '%'||:searchKeyword||'%'
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색결과");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}

	}
	
	private void test1(Map<String , String> map) {
		Set<String> keys = map.keySet(); 
		// Keyset : key와 value 두개다 포함.
		// Set<String> keys 라는 참조변수에 map데이터를 저장한다.
		
		for(String key : keys) { 
			// keys에 저장된 데이터를 불러오는데 키만 불러오면 알아서 value값도 오기 때문에
			// 확장 for문으로 불러온다.
			BooleanBuilder builder = new BooleanBuilder();
			QBoard qboard = QBoard.board;
			
			if(key.equals("TITLE")) {
				// select b from Board b where title like '%'||:searchKeyword||'%'
				builder.and(qboard.title.like("%" + map.get(key) + "%"));
			} else if(key.equals("CONTENT")) {
				// select b from Board b where content like '%'||:searchKeyword||'%'
				builder.and(qboard.content.like("%" + map.get(key) + "%"));
			}
			
			Pageable paging = PageRequest.of(0, 5);
			
			Page<Board> boardList = boardRepo.findAll(builder, paging);
			
			System.out.println("검색결과");
			for(Board board : boardList) {
				System.out.println("--->" + board.toString());
			}	
		}
	}
	
	
	// 2. cnt가 50보다 큰 데이터 출력
	private void test2(Map<String , String> map, Long cntt) {
		Set<String> keys = map.keySet(); 
		// Keyset : key와 value 두개다 포함.
		// Set<String> keys 라는 참조변수에 map데이터를 저장한다.
		
		for(String key : keys) { 
			// keys에 저장된 데이터를 불러오는데 키만 불러오면 알아서 value값도 오기 때문에
			// 확장 for문으로 불러온다.
			BooleanBuilder builder = new BooleanBuilder();
			QBoard qboard = QBoard.board;
			
			if(key.equals("TITLE")) {
				// select b from Board b where title like '%'||:searchKeyword||'%'
				builder.and(qboard.title.like("%" + map.get(key) + "%")).and(qboard.cnt.goe(cntt));
			} else if(key.equals("CONTENT")) {
				// select b from Board b where content like '%'||:searchKeyword||'%'
				builder.and(qboard.content.like("%" + map.get(key) + "%")).and(qboard.cnt.goe(cntt));
			}
			
			// %title : title로 끝나는 데이터 전부
			// title% : title로 시작하는 데이터 전부
			// %title% : title이 포함된 모든 데이터
			
			Pageable paging = PageRequest.of(0, 5);
			
			Page<Board> boardList = boardRepo.findAll(builder, paging);
			
			System.out.println("검색결과");
			for(Board board : boardList) {
				System.out.println("--->" + board.toString());
			}	
		}
	}
	
	// 3. Page 기능 추가.
	

	@Test
	public void testDynamicQuery() {
		// 1. %title1%인 데이터 출력
//		test("TITLE", "title1");
//		test("CONTENT", "content2");
		
//		Map<String, String> map = new HashMap<>();
//		map.put("TITLE", "title1"); // key : value 설정
//		map.put("CONTENT", "content2");
//		test1(map);
		
		// 2. cnt가 50보다 큰 데이터를 출력
//		Map<String, String> map = new HashMap<>();
//		map.put("TITLE", "title1"); // key : value 설정
//		map.put("CONTENT", "content2");
//		test2(map, 50L);
		
		
		// 3. Page 기능 추가
	}
}


/*
	%  ~ % 개념
	
	%title : title로 끝나는 데이터 전부
	title% : title로 시작하는 데이터 전부
	%title% : title이 포함된 모든 데이터
	
	함수 종류
	.goe(value) : value보다 크거나 같은 값. >= 와 같은 개념이다. 
*/

