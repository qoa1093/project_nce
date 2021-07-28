package kr.green.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.service.MemberService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	MemberService memberService;
	
	@GetMapping("/")
	public ModelAndView home(ModelAndView mv) {
		
		mv.addObject("title","메인");
		mv.setViewName("/template/main/home");
		return mv;
	}
	@GetMapping("/main/home")
	public ModelAndView returnHome(ModelAndView mv) {
		
		mv.addObject("title","메인");
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
