package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jdk.internal.org.jline.utils.Log;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		log.info(cri);
		PageMaker pm = new PageMaker();
		cri.setPerPageNum(2);// 한페이지에 숫자 두개씩 보여주기
		pm.setCriteria(cri); //현재페이지 설정
		pm.setDisplayPageNum(2); //바에 숫자 두개씩 
		int totalCount = boardService.getTotalCount(cri);
		pm.setTotalCount(totalCount);//db에서 전체갯수 숫자 가져옴 
		pm.calcData();
		log.info(pm);
		//서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//화면에 모든 게시글을 전송
		mv.addObject("list", list);
		/*if(list != null) {
			for(BoardVO tmp : list) {
				System.out.println(tmp);
			}
		}*/
		mv.addObject("pm", pm);
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		System.out.println(num);
		//게시글을 가져오기 전 조회수를 증가
		//서비스에게 게시글 번호를 주면서 게시글 조회수를 1증가시키라고 시킴
		boardService.updateViews(num);		
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전달, 화면으로 보낼 이름은 board로
		mv.addObject("board", board);
		System.out.println(board);
		mv.setViewName("board/detail");
		return mv;
	}
			//url에서 ?뒷부분은 화면에서 서버로 넘겨주는 데이터 -> 매개변수로 받기로 함
			//int아닌 이유는 num 없을때도 실행되게 하기 위해서 (얘는 없으면 null값 int는 에러메세지뜸)
	@RequestMapping(value="/board/register", method=RequestMethod.GET)//등록화면은 겟, 실제 게시글 전송처리는(길어서) 포스트로
	public ModelAndView boardRegisterGet(ModelAndView mv) {

		mv.setViewName("board/register");
		return mv;
	}
	//화면에서 보내준 제목 작성자 내용을 받아서 콘솔에 출력
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board) {
		//서비스에게 게시글정보(제목,작성자,내용)을 주면서 게시글을 등록하라고 시킴
		boardService.insertBoard(board);
		//System.out.println(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)//등록화면은 겟, 실제 게시글 전송처리는(길어서) 포스트로
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVO board = boardService.getBoard(num);	
		mv.addObject("board", board);
		mv.setViewName("board/modify");
		return mv;
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)//등록화면은 겟, 실제 게시글 전송처리는(길어서) 포스트로
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board) {
		//System.out.println(board);
		//서비스에게 게시글을 주면서 수정하라고 요청
		boardService.updateBoard(board);
		//수정이 완료되면 detail로 이동
		mv.addObject("num",board.getNum());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	@RequestMapping(value="/board/delete")
	public ModelAndView boardDelete(ModelAndView mv, Integer num) {
		//서비스에게 게시글 번호를 주면서 삭제하라고 요청
		boardService.deleteBoard(num);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
}
 