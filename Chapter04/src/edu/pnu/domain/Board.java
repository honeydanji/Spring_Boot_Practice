package edu.pnu.domain;

// DataBase 설계

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// @Table(name = "변경이름") // 테이블 이름 변경 어노테이션
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI (id 자동생성)
	private Long seq;
	@Column(length=40) // varchar(40)
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE) // 날짜만 자동으로 들어감.
	private Date createDate;
	private Long cnt;
	
	public Long getSeq() {
		return seq;
	}
	
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Long getCnt() {
		return cnt;
	}
	
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
}
