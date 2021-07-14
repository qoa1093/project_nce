package kr.green.springtest.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);

	void insertBoard(BoardVO board, MemberVO user);

	int deleteBoard(Integer num,MemberVO user);

	int updateBoard(BoardVO board, MemberVO user);

	int getTotalCount(Criteria cri);

	

	
	

}
