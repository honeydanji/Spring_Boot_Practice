package com.pethospital.domain;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet_board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private int boardId;

    @Column(name="user_id")
    private String userId;
    
    private String nickname; 	// 게시글 닉네임
    private String title; 		// 게시글 제목
    private String content; 	// 게시글 내용
    private String imagefile; 	// 이미지파일 (여러개)
    private Timestamp regdate;
    private Timestamp updatedate;
    private Timestamp deletedate;
    private int likes; 			// 좋아요
    private int views; 			// 조회수
}
