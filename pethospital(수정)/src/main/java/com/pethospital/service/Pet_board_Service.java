package com.pethospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.repository.Pet_board_Repository;

@Service
public class Pet_board_Service {

	@Autowired
	Pet_board_Repository petBoardRepository;
	
	
	
}
