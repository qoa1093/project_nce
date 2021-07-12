package kr.green.spring.service;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO signin(MemberVO user) {
		//회원 정보가 없거나 아이디가 없으면 null을 반환
		if(user == null || user.getId() == null) {
			return null; //아이디는 기본키라서 null값을 가지면 안됨
		}
		//다오에게 아이디를 알려주면서 회원 정보를 가져오라고 시킴
		MemberVO dbUser = memberDao.getMember(user.getId());
		//가져온 회원 정보와 비밀번호를 확인하여 일치하면 회원정보를 반환하고
		//일치하지 않으면 null을 반환
		if(dbUser == null || !passwordEncoder.matches(user.getPw(), dbUser.getPw())/*dbUser.getPw().equals(user.getPw())*/) {
			return null;
		}
		//passwordEncoder.matches(A, B);
		//A는 암호화 안된 문자열, B는 암호화된 문자열, 같은 값인지 확인
		//passwordEncoder.matches(user.getPw(), dbUser.getPw());
		return dbUser;
	}


	@Override
	public boolean signup(MemberVO user) {
		// 이미 가입된 아이디가 있으면 false를 리턴
		if(user ==null || memberDao.getMember(user.getId())!= null) {
			return false;
		}
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		//없으면 dao에게 회원정보를 주면서 회원가입하라고 시킨 후 true를 리턴
		memberDao.signup(user);
		return true;
	}


	@Override
	public MemberVO getMember(String id) {
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		//가져온 회원 정보를 전달
		
		return memberDao.getMember(id);
	}
	@Override
	public MemberVO updateMember(MemberVO user) {
		//다오에게 아이디를 주면서 기존 회원 정보를 가져오라고 시킴
		if(user == null) {
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		//일치하는 회원 정보가 없으면 0을 반환
		if(dbUser == null) {
			return null;
		}
		//기존 회원 정보 중 성별, 이메일을 수정할 회원정보의 성별, 이메일로 변경
		dbUser.setGender(user.getGender());
		dbUser.setEmail(user.getEmail());
		//수정할 회원 정보에 비밀번호가 있으면 기존 회원 정보의 비밀번호를 변경
		if(user.getPw()!= null && !user.getPw().equals("")) {
			String encodePw = passwordEncoder.encode(user.getPw());
			dbUser.setPw(encodePw);
		}
		
		//다오에게 수정할 회원정보를 주면서 변경하라고 시킴
		if(memberDao.updateMember(dbUser) == 0) {
			return null; 
		}return dbUser;
	}


	@Override
	public MemberVO getMember(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		return (MemberVO)request.getSession().getAttribute("user");
	}
}


