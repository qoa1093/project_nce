package kr.green.springtest.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override //컨트롤러 가기전에 자동로그인인지 아닌지를 체크
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();//세션에 있는 유저정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user"); 
		if(user == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				user = memberService.getMemberByCookie(loginCookie.getValue());
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
		}
		return true;
	}
}
