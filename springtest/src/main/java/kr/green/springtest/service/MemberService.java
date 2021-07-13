package kr.green.springtest.service;

import kr.green.springtest.vo.MemberVO;

public interface MemberService {

	public void signup(MemberVO user);
	public MemberVO signin(MemberVO user);


}
