package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NonMemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();//세션에 있는 유저정보를 가져옴
		Object user = session.getAttribute("user"); 
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/"); //메인으로 보냄
			return false;//원래 가려던 url로 못감
		}
		return true;//원래 가려던 url로 감
	}
}
