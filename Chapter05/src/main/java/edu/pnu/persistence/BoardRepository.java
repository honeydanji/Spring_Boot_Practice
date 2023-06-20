package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

//	@Query("select b from Board b where b.title like %?1% order by b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
//
//	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
//	List<Board> queryAnnotationTest2(String searchKeyword);
//
//	@Query("select b.seq, b.title, b.writer, b.createDate from Board b "
//			+ "where b.title like %:searchKeyword% order by b.seq DESC")
//	List<Object[]> queryAnnotationTest3(@Param("title1") String searchKeyword);
//
//	@Query(value="select seq, title, writer, createDate "
//			+ "from board where title like '%'||:sk||'%' "
//			+ "order by seq desc", nativeQuery = true)
//	List<Object[]> queryAnnotationTest4(@Param("sk") String searchKeyword);
	
	
	Page<Board> findAll(Pageable paging);

	List<Board> findBoardByTitleContaining(String title, Pageable paging);

	List<Board> findBoardByTitleContainingAndCntGreaterThanEqual(String title, Long a);

	List<Board> findBoardByCntGreaterThanEqualAndCntLessThanEqualOrderByCntAsc(Long a, Long b);

	List<Board> findBoardByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);

}
