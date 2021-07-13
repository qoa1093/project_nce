package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.MemberDAO;
import kr.green.springtest.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;
	@Autowired
    BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public void signup(MemberVO user) {
		if(user == null)
			return;
		//화면뿐만 아니라 서버에서도 필수항목체크
		if(user.getId() == null ||user.getId().trim().length() == 0 || 
			user.getPw() == null ||user.getPw().trim().length() == 0 ||
			user.getName() == null ||user.getName().trim().length() == 0 ||
			user.getEmail() == null ||user.getEmail().trim().length() == 0)
			return;
		//정규표현식 체크해야하는데 나중에(작업 확인 편의성 위해서)
		//암호화
		String ePw = passwordEncoder.encode(user.getPw());
		user.setPw(ePw);
		//회원가입
		memberDao.insertMember(user);
		
	}

	

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null ||user.getId().trim().length() == 0
			||user.getPw() == null || user.getPw().trim().length() == 0){
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null )
			return null;
		if(passwordEncoder.matches(user.getPw(), dbUser.getPw()))
			return dbUser;
		return null;
	}
	
	

}
