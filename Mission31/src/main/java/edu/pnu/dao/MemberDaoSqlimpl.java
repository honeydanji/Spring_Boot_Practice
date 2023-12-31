package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoSqlimpl implements MemberInterface{

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mission2";
	private String username = "scott";
	private String password = "tiger";

	private Connection con;
	
	public MemberDaoSqlimpl() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// 데이터 전부 가져오기
	public List<MemberVO> getMembers() {
		List<MemberVO> mm = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from member"));
			
			while(rs.next()) {
				MemberVO m = MemberVO.builder()
								.id(rs.getInt("id"))
								.pass(rs.getString("pass"))
								.name(rs.getString("name"))
								.regidate(rs.getDate("regidate")).build();
				mm.add(m);
			}
			return mm;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// 데이터 id 조회해서 가져오기
	@Override
	public MemberVO getMember(Integer id) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from member where id = %d", id));
			
			MemberVO m = MemberVO.builder()
					.id(rs.getInt("id"))
					.pass(rs.getString("pass"))
					.name(rs.getString("name"))
					.regidate(rs.getDate("regidate")).build();
			
			return m;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 데이터 추가하기
	@Override
	public MemberVO addMember(MemberVO member) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("insert into member (pass, name) values ('%s', '%s')", member.getPass(), member.getName()));
			
			// alt + shift + L : 지역변수를 따로 만들어준다.
			String string = "select * from member where id = (select Max(id) from member)";
			ResultSet rs = stmt.executeQuery(String.format(string));
			
			// 쿼리를 실행하고 값을 찍으면 처음에는 null이 출력 된다.
			// rs.next() : 다음 값을 가리키는 메소드
			rs.next();
			MemberVO m = MemberVO.builder()
					.id(rs.getInt("id"))
					.pass(rs.getString("pass"))
					.name(rs.getString("name"))
					.regidate(rs.getDate("regidate")).build();
			
			return m;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 데이터 수정하기
	@Override
	public MemberVO updateMember(MemberVO member) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("update member set pass = '%s', name = '%s' where id = %d ", member.getPass(), member.getName(), member.getId()));
			
			ResultSet rs = stmt.executeQuery(String.format("select * from member where id = %d", member.getId()));
			
			// 쿼리를 실행하고 값을 찍으면 처음에는 null이 출력 된다.
			// rs.next() : 다음 값을 가리키는 메소드
			rs.next();
			MemberVO m = MemberVO.builder()
					.id(rs.getInt("id"))
					.pass(rs.getString("pass"))
					.name(rs.getString("name"))
					.regidate(rs.getDate("regidate")).build();
			
			return m;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 데이터 삭제하기
	@Override
	public int deleteMember(Integer id) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("DELETE FROM member WHERE id = %d", id));
			
			return 1;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
