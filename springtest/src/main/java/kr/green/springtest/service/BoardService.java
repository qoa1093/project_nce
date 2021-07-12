package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);

	void insertBoard(BoardVO board);

	int deleteBoard(Integer num);

	int updateBoard(BoardVO board);

	int getTotalCount(Criteria cri);

}
