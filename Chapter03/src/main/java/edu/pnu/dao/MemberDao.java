package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.Member;

public class MemberDao {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mission2";
	private String username = "scott";
	private String password = "tiger";
	
	private Connection con;

	// Database Connection 설정 (con)
	public MemberDao() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// member2 데이터 추가하기
	public Member insertMember(Member member) {
		try {
			String sql = "insert into member2 (name, age, nickname) values (?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setInt(2, member.getAge());
			stmt.setString(3, member.getNickname());
			stmt.executeUpdate();
			
			System.out.println("추가 성공");
			
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 모든 member2 데이터 가져오기
	public List<Member> getMembers(){
		List<Member> mm = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from member2"));
			
			while(rs.next()) {
				Member m = Member.builder()
							.id(rs.getLong("id"))
							.name(rs.getString("name"))
							.age(rs.getInt("age"))
							.nickname(rs.getString("nickname"))
							.build();
				mm.add(m);
				
			}
			rs.close();
			stmt.close();
			return mm;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 데이터 가져오기
	public Member getMember(Long id) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from member2 where id =%d",id));
			
			rs.next();
			
			Member m = Member.builder()
						.id(rs.getLong("id"))
						.name(rs.getNString("name"))
						.age(rs.getInt("age"))
						.nickname(rs.getString("nickname"))
						.build();
			rs.close();
			stmt.close();
			
			return m;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
