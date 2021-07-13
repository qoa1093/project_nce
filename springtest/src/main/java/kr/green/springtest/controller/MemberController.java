package kr.green.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@GetMapping(value="/signup")// ,메소드=get 쓴거랑 똑같음 requestmapping 대신 씀
	public ModelAndView signupGet(ModelAndView mv) {
		//MemberVO user = new MemberVO(); 아래 매개변수MemberVO user와 동일 
		//System.out.println(user.getId().trim().length());
		mv.setViewName("member/signup");
		return mv;
	}
	@PostMapping(value="/signup")// ,메소드=post 쓴거랑 똑같음 requestmapping 대신 씀
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		memberService.signup(user);
		mv.setViewName("redirect:/");
		return mv;
	}
	/*매개변수 user를 쓰면 객체가 생성된 후, 화면에서 전달한 name과 일치하는 변수명을 가진
	 * 멤버변수의 setter를 이용하여 값을 재설정
	 * 일반적으로 매개변수는 객체를 자동으로 생성하는건 아님  */
	
	@RequestMapping(value = "/signin", method= RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("member/signin");
		log.info(mv);
		return mv;
	}
	@RequestMapping(value = "/signin", method= RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		MemberVO loginUser = memberService.signin(user);
		if(loginUser != null) {			mv.setViewName("redirect:/");}
		else {							mv.setViewName("redirect:/signin");}
		mv.addObject("user",loginUser);
		//log.info(mv);
		return mv;
	}
	
	
}
