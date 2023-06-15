package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.member.MemberInterface;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	
	// 다형성 :
	// 부모 클래스와 자식클래스가 형성되어 있으면, 일반적인 생각은 자식만 부모의 데이터를 쓸 수 있다 생각하는데
	// 사실은 부모도 자식클래스의 데이터를 사용할 수 있다. 이게 다형성이다.
	@Autowired
	private MemberInterface memberDao;
	// MemberInterface라고 표현은 되어 있지만 사실 인터페이스를 상속 받은 자식 클래스들의
	// 빈의 종속성을 부여하는 것이다. 이게 가능한 이유가 자바의 다형성이 있기에 가능한 것이다.
	// MemberDaoH2Impl implements MemberInterface 이렇게 되어 있으니 
	// MemberInterface가 아닌 MemberDaoH2Impl의 빈의 종속성을 부여하는 것이다.

	@Autowired
	private LogDao logDao;
	//public MemberService() {
		// memberDao = new MemberDaoH2Impl();
		// memberDao = new MemberDaoListImpl();
		
		// logDao = new LogDaoH2Impl();
		// logDao = new LogDaoFileImpl();
	//}
	
	@SuppressWarnings("unchecked")
	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberDao.getMembers();
		List<MemberVO> list = (List<MemberVO>) map.get("data");
		if (list != null)	logDao.addLog("get", (String)map.get("sql"), true);
		else				logDao.addLog("get", (String)map.get("sql"), false);
		return list;
	}

	public MemberVO getMember(Integer id) {
		Map<String, Object> map = memberDao.getMember(id);
		MemberVO member = (MemberVO) map.get("data");
		if (member != null)	logDao.addLog("get", (String)map.get("sql"), true);
		else				logDao.addLog("get", (String)map.get("sql"), false);
		return member;
	}

	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = memberDao.addMember(member);
		MemberVO m = (MemberVO) map.get("data");
		if (m != null)	logDao.addLog("post", (String)map.get("sql"), true);
		else			logDao.addLog("post", (String)map.get("sql"), false);
		return m;		
	}

	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = memberDao.updateMember(member);
		MemberVO m = (MemberVO) map.get("data");
		if (m != null)	logDao.addLog("put", (String)map.get("sql"), true);
		else			logDao.addLog("put", (String)map.get("sql"), false);	
		return m;
	}

	public MemberVO deleteMember(Integer id) {
		Map<String, Object> map = memberDao.deleteMember(id);
		MemberVO m = (MemberVO) map.get("data");
		if (m != null)	logDao.addLog("delete", (String)map.get("sql"), true);
		else			logDao.addLog("delete", (String)map.get("sql"), false);
		return m;
	}
}
