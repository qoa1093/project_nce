package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * url 패턴 분석
	 */
	@Autowired
    MemberService memberService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("main/home");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)//post아니고 겟이라 처리안함
	public ModelAndView signinGet(ModelAndView mv) {	
		mv.setViewName("member/signin");		
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv , MemberVO user) {	
		//System.out.println(user);
		//서비스에게 아이디와 비밀번호를 전달하면 해당 정보가 db에 있으면 
		//회원정보를, 없으면 null을 반환
		//작업이 다 끝난 후 url가 /signin인 곳으로 넘어감
		MemberVO dbUser = memberService.signin(user);
		//회원정보가 있으면 => 로그인에 성공하면
		if(dbUser != null) {
			mv.setViewName("redirect:/"); //메인화면으로 넘어가고	 
		//회원정보가 없으면 => 일치하는 아이디가 없던지, 비밀번호가 잘못되던지
		//				==> 로그인 실패
		}else {
			mv.setViewName("redirect:/signin"); //현재페이지에 있는 것 
		}
		mv.addObject("user",dbUser);
		//화면을 직접 연결하지 않음
		//다른 url를 실행시키는 방법 뒤에 내가 원하는 주소 쓰면 됨	
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {	
		mv.setViewName("member/signup");		
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {	
		//System.out.println(user);
		//서비스에게 회원정보르 주면서 회원 가입하라고 일을 시키고, 회원가입 성공시 true
		//실패하면 false를 알려달라고 요청
		boolean isSignup = memberService.signup(user);
		//회원가입에 성공하면 메인으로 실패하면 회원가입 페이지로
		if(isSignup) {
			mv.setViewName("redirect:/");		
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public ModelAndView memberMypageGet(ModelAndView mv/*, String id*/) {	
		//System.out.println(id);
		//서비스에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		//MemberVO user = memberService.getMember(id);
		//System.out.println(user);
		//가져온 회원정보를 화면에 전달
		//mv.addObject("user",user); //세션에서 가져온 로그인정보로 가져올수 있음
		mv.setViewName("member/mypage");		
		return mv;
	}
	@RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {	
		//System.out.println(user);
		//서비스에게 회원정보를 주면서 수정하라고 요청
		//request에 있는 세션 안에 있는 로그인한 회원 정보를 가져옴
		MemberVO sessionUser = memberService.getMember(request);
		//세션에 로그인한 회원 정보가 있고, 세션에 있는 아이디와 수정할 아이디가 같으면 회원 정보 수정함 : 개발자도구 열어서 직접 수정하는걸 막아줌
		if(sessionUser != null && sessionUser.getId().equals(user.getId())) {
			MemberVO updateUser = memberService.updateMember(user);
			if(updateUser != null) {
				request.getSession().setAttribute("user", updateUser);
			}
		}
		mv.setViewName("redirect:/member/mypage");		
		return mv;
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv,HttpServletRequest request) {
		//세션에 있는 유저정보를 지워주고 홈으로 되돌아감 : 로그아웃 기능
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");		
		return mv;
	}
	
}


