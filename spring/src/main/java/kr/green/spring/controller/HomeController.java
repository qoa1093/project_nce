package kr.green.spring.controller;

import java.util.ArrayList;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@Autowired
	private JavaMailSender mailSender;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/template/main/home");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)//post아니고 겟이라 처리안함
	public ModelAndView signinGet(ModelAndView mv) {	
		mv.setViewName("/template/member/signin");		
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
		mv.setViewName("/template/member/signup");		
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
		mv.setViewName("/template/member/mypage");		
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
	@ResponseBody
	@GetMapping(value = "/member/idcheck/{id}")//경로에 있는 변수 //가져와서 문자열로 저장
	public String memberIdcheckGet(@PathVariable("id") String id) {
		MemberVO user = memberService.getMember(id);
		String res = user != null? "IMPOSSIBLE" : "POSSIBLE";
		return res;
	}
	@ResponseBody
	@PostMapping(value = "/member/signin")//경로에 있는 변수 //가져와서 문자열로 저장
	public String memberSigninPost(@RequestBody MemberVO user, HttpServletRequest r) {
		//System.out.println(user);
		MemberVO dbUser = memberService.signin(user);
		if(dbUser != null)
			r.getSession().setAttribute("user", dbUser);
		return dbUser != null ? "success" : "fail";
	}
	/*@GetMapping(value = "/mail/test")//경로에 있는 변수 //가져와서 문자열로 저장
	public ModelAndView mailTestGet(ModelAndView mv) {
		mv.setViewName("/template/main/mail");
		return mv;
	}
	@PostMapping(value = "/mail/test")//경로에 있는 변수 //가져와서 문자열로 저장
	public ModelAndView mailTestGet(ModelAndView mv, String title, String content, String email) {
		 try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");

		        messageHelper.setFrom("123@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(email);     // 받는사람 이메일
		        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		        messageHelper.setText("","<h1>내용</h1>");  // 메일 내용
		        mailSender.send(message);
		        System.out.println(message);
		    } catch(Exception e){
		        System.out.println(e);
		    }

		mv.setViewName("/template/main/mail");
		return mv;
	}
	*/

	@GetMapping(value = "/find/pw")//경로에 있는 변수 //가져와서 문자열로 저장
	public ModelAndView findPwGet(ModelAndView mv) {
		mv.setViewName("/template/main/findpw");
		return mv;
	}
	@ResponseBody
	@GetMapping(value = "/find/pw/{id}")//경로에 있는 변수 //가져와서 문자열로 저장
	public String findPwGet(@PathVariable("id") String id) {
		//System.out.println(id);
		MemberVO user = memberService.getMember(id);
		if(user == null)
			return "FAIL";
		
		 try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");
		        //임시 비밀번호 발급
		        String newPw = newPw();
		        //새 비밀번호를 디비에 저장
		        user.setPw(newPw);
		        memberService.updateMember(user);
		        
		        messageHelper.setFrom("abc@naver.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(user.getEmail());     // 받는사람 이메일
		        messageHelper.setSubject("새 비밀번호를 발급합니다."); // 메일제목은 생략이 가능하다
		        messageHelper.setText("","발급된 새 비밀번호는 <b>" + newPw + "</b>입니다.");  // 메일 내용
		        
		        mailSender.send(message);
		        return "SUCCESS";
		        //System.out.println(message);
		    } catch(Exception e){
		        System.out.println(e);
		    }
			return "FAIL";
	}
	//8자리의 숫자 or 영어 대소문자로 된 비밀번호
	private String newPw() {
		// 랜덤숫자 : 0~9 => 문자열 : 0~9
		// 랜덤숫자 : 10~35 => 문자열 a~z
		// 랜덤숫자 : 36~61 => 문자열 : A~Z 
		//12 => c
		String pw="";
		int max = 61, min = 0;
		for(int i=0; i<8; i++) {
			int r = (int)(Math.random()*(max-min+1)) + min;
			//int r = (int)(Math.random()*62);
			if(r<=9) {
				pw += r;
			}else if( r<=35) {
				pw += (char)('a'+(r-10));
			}else {
				pw += (char)('A'+(r-36));
			}
		}
		return pw;
	}
	@GetMapping(value = "/find/id")//경로에 있는 변수 //가져와서 문자열로 저장
	public ModelAndView findIdGet(ModelAndView mv) {
		mv.setViewName("/template/main/findid");
		return mv;
	}
	@ResponseBody
	@PostMapping(value = "/find/id")
	public String findIdPost(String email) {
		System.out.println(email);
		ArrayList<MemberVO> userList = memberService.getMemberByEmail(email);
		if(userList == null || userList.size() == 0)
			return "FAIL";
		 try {
			 	ArrayList<String> idList = new ArrayList<String>();
			 	for(MemberVO user : userList) {
			 		idList.add(user.getId());
			 	}
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");
		        
		        messageHelper.setFrom("abc@naver.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(email);     // 받는사람 이메일
		        messageHelper.setSubject("가입된 아이디를 안내드립니다."); // 메일제목은 생략이 가능하다
		        messageHelper.setText("","가입된 아이디는 <b>" + idList.toString().replaceAll("[\\[\\]]","") + "</b>입니다.");  // 메일 내용 |  대괄호 제외하고 보내기
		        
		        System.out.println(idList + "" + message);
		        mailSender.send(message);
		        return "SUCCESS";
		    } catch(Exception e){
		        System.out.println(e);
		    }
			return "FAIL";
	}
	
}


