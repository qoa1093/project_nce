package kr.green.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import lombok.Data;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * url 패턴 분석
	 */
	@Autowired
    MemberService memberService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
	
		mv.setViewName("home");
		mv.addObject("name", "홍길동");
		System.out.println(memberService.getMember("abc123"));

		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv, UserVo user, @RequestParam("hobby") String[] hobby) {
		
		mv.setViewName("signin");
		System.out.println("id: " + user.getId());
		System.out.println("pw: " + user.getPw());
		for(String tmp:hobby) {
		System.out.println("hobby: " + tmp);
		}
		
		return mv;
	}
	
}
@Data
class UserVo{
	private String id;
	private String pw;
}
