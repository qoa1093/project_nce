package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.pagination.*;
import kr.green.springtest.service.*;
import kr.green.springtest.vo.*;
import lombok.extern.log4j.Log4j;

//@Repository
@Log4j
@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/list")
	public ModelAndView list(ModelAndView mv, String msg, Criteria cri) {
		cri.setPerPageNum(2);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색타입, 검색어)에 대한 총 게시글 수를 가져와야함 totalCount
		int totalCount = boardService.getTotalCount(cri);;
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		mv.addObject("pm", pm);
		log.info(pm);
		mv.addObject("list", list);
		mv.addObject("msg", msg);
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView detail(ModelAndView mv, Integer num, String msg) {
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		log.info(board);
		mv.addObject("board",board);
		mv.addObject("msg",msg);
		//Log.info(num);
		mv.setViewName("board/detail");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {	
		mv.setViewName("board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest r) {
		log.info(board);
		MemberVO user = memberService.getMember(r);
				
		boardService.insertBoard(board, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer num) {
		log.info("/board/modify : "+num);
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("board/modify");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv ,BoardVO board) {
		log.info("/board/modify: POST : "+ board);
		int res = boardService.updateBoard(board);
		String msg = res != 0 ? board.getNum()+"번 게시글이 수정되었습니다." : "없는 게시글 입니다.";
		mv.addObject("msg", msg);
		mv.addObject("num", board.getNum());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num) {
		log.info("/board/delete : "+num);
		int res = boardService.deleteBoard(num);
		if(res != 0) {
			mv.addObject("msg", num+"번 게시글을 삭제했습니다.");
		}else {
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	
}
