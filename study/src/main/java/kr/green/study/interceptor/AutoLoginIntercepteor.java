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

public class AutoLoginIntercepteor extends HandlerInterceptorAdapter {
	//prehandle로 시작해야 함 모든 url이 해당 url로 가기전, 즉 컨트롤러로 가기전에 체크해주기
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");//겟~은 리턴타입 오브젝트(모든 클래스조상클래스인 오브젝트)(부모->자식은 자동형변환 안됨 = 명시적 형변환)
		//세션에 회원 정보가 있으면 자동 로그인 기능을 활용할 필요가 없고 없으면 자동 로그인을 해야하는지 확인
		if(user == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");// 개발자도구의 로그인쿠키정보를 가져와서
			if(loginCookie != null) { //로그인쿠키가 있으면 자동로그인 시도, 없으면 안함
				user = memberService.getMemberByCookie(loginCookie.getValue());
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
			//원래 가려던 컨트롤러로 가지않고 리다이렉트를 통해서 다른 url로 갈때 사용
		}
		return true; //원래 가려던 컨트롤러로 가게하는게 목적
	}
}
