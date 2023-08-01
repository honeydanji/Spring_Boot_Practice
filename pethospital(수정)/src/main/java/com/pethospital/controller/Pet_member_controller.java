package com.pethospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.Pet_member;
import com.pethospital.dto.Pet_member_dto;
import com.pethospital.service.Pet_member_Service;

@RestController
@RequestMapping("/api") // "/api" + 아래 각각의 맵핑 주소 
public class Pet_member_controller {

    @Autowired
    private Pet_member_Service pet_member_service;

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody Pet_member_dto petMemberDto) {
        pet_member_service.registerPetMember(petMemberDto); // 프론트에서 보낸 member 정보를 서비스로 보낸다.
        return ResponseEntity.status(HttpStatus.OK).body("회원가입을 축하드립니다.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginMember(@RequestBody Pet_member petMember) {
    	if (pet_member_service.loginPetMember(petMember.getUserId(), petMember.getPassword()) == 1) {
    		return ResponseEntity.status(HttpStatus.OK).body("환영합니다.");
    	}else if(pet_member_service.loginPetMember(petMember.getUserId(), petMember.getPassword()) == -1) {
    		return ResponseEntity.status(HttpStatus.OK).body("비밀번호가 틀렸습니다.");
    	}else return ResponseEntity.status(HttpStatus.OK).body("아이디가 존재하지 않습니다.");
    }
}
