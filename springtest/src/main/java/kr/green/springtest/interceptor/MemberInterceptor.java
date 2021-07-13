package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();//세션에 있는 유저정보를 가져옴
		Object user = session.getAttribute("user"); 
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/signin"); //유저정보없으면 로그인하라고 보냄
			return false;
		}
		return true;
	}
}
