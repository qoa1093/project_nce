package kr.green.springtest.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest.vo.MemberVO;

public interface MemberService {

	public void signup(MemberVO user);
	public MemberVO signin(MemberVO user);
	public MemberVO getMember(HttpServletRequest r);
	public MemberVO updateMember(MemberVO user, MemberVO sUser);


}
