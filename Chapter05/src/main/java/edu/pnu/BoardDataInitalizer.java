package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

//@Component // 자동으로 감지해서 실행시킨다.
public class BoardDataInitalizer implements ApplicationRunner {

	@Autowired
	BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Random rd = new Random();
		for (int i = 1; i <= 100; i++) {
			
			Board board = new Board();
			board.setTitle("title" + i);
			board.setWriter("데이터" + i);
			board.setContent("content" + i);
			board.setCreateDate(new Date());
			board.setCnt(rd.nextLong(0, 101));
			
			boardRepo.save(board);
		}

	}

}
