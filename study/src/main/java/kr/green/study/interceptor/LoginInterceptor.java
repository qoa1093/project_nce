package kr.green.study.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");

	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user); //오토로그인"user"의 세션어트리뷰트"user"랑 이름 같게 하기 (겟, 셋 모두 같은 "abc"로 맞추고, 화면에서 불러올때도 ${abc.~}로 불러야 함/로그인인터셉트가 중심)
	        if(user.getUseCookie() != null) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	int timeSecond = 60 * 60 * 24 * 7; //7일을 초로 환산
	        	loginCookie.setPath("/");
	        	loginCookie.setMaxAge(timeSecond);
	        	response.addCookie(loginCookie); //현재시간을 밀리세컨으로 계산해주고 7일뒤의 시간을 계산해서 넣어주면 7일뒤의 날짜정보가 생성됨
	        	memberService.keepLogin(user.getId(), session.getId(), new Date(System.currentTimeMillis()+ timeSecond * 1000));
	        }
	    }
	}
}
