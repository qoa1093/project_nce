package kr.green.springtest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;
import lombok.extern.log4j.Log4j;

//@Repository
@Log4j
@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	public ModelAndView list(ModelAndView mv) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		//Log.info(list);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView detail(ModelAndView mv, Integer num) {
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		log.info(board);
		mv.addObject("board",board);
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
	public ModelAndView registerPost(ModelAndView mv, BoardVO board) {
		log.info(board);
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
}
