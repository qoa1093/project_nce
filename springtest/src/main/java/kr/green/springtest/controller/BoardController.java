package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
		//log.info(pm);
		mv.addObject("list", list);
		mv.addObject("msg", msg);
		mv.setViewName("/template/board/list");
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView detail(ModelAndView mv, Integer num, String msg, HttpServletRequest r) {
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		//log.info(board);
		mv.addObject("board",board);
		mv.addObject("msg",msg);
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		mv.addObject("fileList", fileList);
		MemberVO user = memberService.getMember(r);
		RecommendVO rvo = boardService.getRecommend(num, user);
		mv.addObject("recommend", rvo);
		//log.info("파일리스트는"+fileList);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {	
		mv.setViewName("/template/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest r, MultipartFile[] files) {
		log.info(board);
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board, user,files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer num) {
		//log.info("/template//board/modify : "+num);
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		//첨부파일 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		//화면에 첨부파일 전송
		mv.addObject("fileList", fileList);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST) //files는 모디파이의 인풋창 files와 맞춰줌
	public ModelAndView modifyPost(ModelAndView mv ,BoardVO board, HttpServletRequest r, MultipartFile[] files, Integer[] filenums) {
		//log.info("/template//board/modify: POST : "+ board);
		MemberVO user = memberService.getMember(r);
		int res = boardService.updateBoard(board, user, files, filenums);
		String msg="";
		mv.setViewName("redirect:/board/detail");
		if(res == 1)
			msg = board.getNum()+"번 게시글이 수정되었습니다.";
		else if(res ==0)
			msg="없는 게시글입니다.";
		else if(res == -1) {
			msg="잘못된 접근입니다.";
			mv.setViewName("redirect:/board/list");
		}
		mv.addObject("msg", msg);
		mv.addObject("num", board.getNum());
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num, HttpServletRequest r) {
		log.info("/board/delete : "+num);
		MemberVO user = memberService.getMember(r);
		int res = boardService.deleteBoard(num, user);
		if(res == 1) {
			mv.addObject("msg", num+"번 게시글을 삭제했습니다.");
		}else if(res == 0){
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}else if(res == -1){
			mv.addObject("잘못된 접근입니다.");
		}		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@ResponseBody
	@RequestMapping("board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    return boardService.downloadFile(fileName);		
	}
	@ResponseBody
	@GetMapping("/recommend/{board}/{state}")
	public String boardRecommend(@PathVariable("board") int board,
			@PathVariable("state") int state,
			HttpServletRequest r){
		MemberVO user = memberService.getMember(r); 
	    return boardService.recommend(board,state,user);		
		//System.out.println("게시글 번호 : " + board);
		//System.out.println("게시글 상태 : " + state);
		//return "ok";
	}
	
	
}
