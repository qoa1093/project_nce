package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDAO;
import kr.green.springtest.vo.BoardVO;

@Repository
@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	@Override
	public ArrayList<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.getBoard(num);
		//return num == null? null : boardDao.getBoard(num);
	}

	@Override
	public int updateViews(Integer num) {
		//게시글 정보를 가져오라고 요청
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		board.setViews(board.getViews()+1);
		return boardDao.updateBoard(board);
	}

	@Override
	public void insertBoard(BoardVO board) {
		if(board == null) {
		return;
		}
		boardDao.InsertBoard(board);
	}
}
