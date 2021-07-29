package kr.green.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class AdminIntercepteor extends HandlerInterceptorAdapter {
	//prehandle로 시작해야 함 모든 url이 해당 url로 가기전, 즉 컨트롤러로 가기전에 체크해주기
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || user.getAuthority().equals("USER")) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true; 
	}
}
