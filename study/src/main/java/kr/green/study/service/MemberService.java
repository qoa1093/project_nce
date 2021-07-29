package kr.green.study.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.green.study.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO signin(MemberVO user);

	Object getMember(String id);

	void signout(HttpServletRequest request, HttpServletResponse response);

	void keepLogin(String id, String id2, Date date);

	MemberVO getMemberByCookie(String value);
	
	MemberVO getMemberByRequest(HttpServletRequest request);
}