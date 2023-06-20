package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // : DB테이블에 대응하는 하나의 클래스 , 주석이 달린 클래스는 JPA가 관리해준다. DB테이블과 매핑할 클래스는 주석을 달아줘야한다.
public class Board {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincruament와 같은 기능을 한다.
	private Long seq;
	private String title;
	@Column(length = 32)
	private String writer;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
}
