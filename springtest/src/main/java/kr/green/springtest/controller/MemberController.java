package kr.green.springtest.controller;

import javax.servlet.http.HttpServletRequest;

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
		mv.setViewName("/template/member/signup");
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
	
	@GetMapping(value = "/signin")
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("/template/member/signin");
		//log.info(mv);
		return mv;
	}
	@PostMapping(value = "/signin")
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		MemberVO loginUser = memberService.signin(user);
		if(loginUser != null) {			mv.setViewName("redirect:/");}
		else {							mv.setViewName("redirect:/signin");}
		mv.addObject("user",loginUser);
		//log.info(mv);
		return mv;
	}
	
	@GetMapping(value = "/member/mypage")
	public ModelAndView memberMypageGet(ModelAndView mv) {
		mv.setViewName("/template/member/mypage");
		return mv;
	}
	@PostMapping(value = "/member/mypage")
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest r) {
		//user : 화면에서 보낸 회원 정보. 정상적이라면 바로 수정해도 되지만
		// 개발자 도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안됨
		//리퀘스트에 있는 세션 정보를 가져옴
		//sUser : 현재 로그인된 회원 정보
		//uUser : 업데이트된 회원 정보(화면정보,로그인된 세션정보)로 user의 아이디와 sUser의 아이디가 일치하지 않으면 null, 일치하면 업데이트된 회원정보가 반환
		MemberVO sUser = memberService.getMember(r);
		MemberVO uUser = memberService.updateMember(user,sUser);
		if(uUser != null)//업데이트가 정상적으로 됐으면
			r.getSession().setAttribute("user", uUser); //세션에 똑같은 이름의 정보가 있으면 덮어씀 :업데이트된 내용으로 변경됨
		//log.info("/member/page: "+sUser);
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	
	@GetMapping(value = "/member/signout")
	public ModelAndView memberSignoutGet(ModelAndView mv, HttpServletRequest r) {
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}

	@ResponseBody
	@GetMapping(value = "/member/idCheck/{id}")
	public String memberIdCheckGet(@PathVariable("id") String id) {
		//System.out.println(id);
		return memberService.idCheck(id) ? "POSSIBLE" : "IMPOSSIBLE";
	}
	
	
}
