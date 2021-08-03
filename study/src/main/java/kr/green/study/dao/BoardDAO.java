package kr.green.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.study.pagination.Criteria;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(Criteria cri);

	BoardVO selectBoard(Integer num);

	void insertBoard(@Param("board")BoardVO board); //맵퍼에서 이프뮨 쓰기 위함

	void updateBoard(BoardVO dbBoard);

	void deleteBoard(Integer num);

	void deleteReplyBoard(Integer num);

	void insertFile(FileVO file);

	void updateViews(Integer num);

	ArrayList<FileVO> selectFileList(Integer num);

	void deleteFile(int num);

	ArrayList<Integer> selectFileNumList(int num);

	FileVO selectFile(Integer tmp);

	int getTotalCount(Criteria cri);

	FileVO selectThumbnail(int num);

}
