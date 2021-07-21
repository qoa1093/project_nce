package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import kr.green.spring.pagination.*;
import kr.green.spring.service.*;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor//모든 멤버변수의 객체를 생성하게 만들어줌(오토와일드 안쓰는 이유) 모든 생성자 만드는 역할
public class ReplyController {
	
	private ReplyService replyService;
	private MemberService memberService;
	
	@PostMapping(value="/reply/ins")
	public String replyInsPost(@RequestBody ReplyVO reply ) {
		replyService.insertReply(reply);
		return "ok";
	}
	@GetMapping(value="/reply/list/{num}/{page}")
	public HashMap<String, Object> replyListGet(@PathVariable("num") Integer num, @PathVariable("page") Integer page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(2);
		ArrayList<ReplyVO> list = replyService.getReplyList(num, cri);
		PageMaker pm = new PageMaker();
		pm.setDisplayPageNum(2);
		pm.setCriteria(cri);
		int totalCount = replyService.getTotalCount(num);
		pm.setTotalCount(totalCount);
		pm.calcData();
		map.put("pm", pm);
		System.out.println(pm);
		map.put("list", list);
		return map;
	}
	@PostMapping(value="/reply/del")
	public String replyDelPost(@RequestBody ReplyVO reply, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		//System.out.println(reply);
		return replyService.deleteReply(reply, user);
	}
}
