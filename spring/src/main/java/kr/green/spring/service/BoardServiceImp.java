package kr.green.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	private String uploadPath = "E:\\JAVA_NCE\\project_nce\\uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		
		return boardDAO.getBoardList(cri);
							
	}

	@Override
	public BoardVO getBoard(Integer num) {
		//게시글 번호가 없으면 게시글이 없다고 전달 => num가 null인지 확인하여 null이면 null을 반환
		 if(num == null) {
			 return null;
		 }
		 //번호가 있으면 다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		 BoardVO board = boardDAO.getBoard(num);
		 //가져온 게시글 전달. 이때 가져온 게시글은 없을수도 있다(null이 들어갈 수도 있다)
		return board;
		//return boardDao.getBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board,  MultipartFile file){
		//다오에게 게시글 정보를 주면서 게시글 등록하라고 시킴
		boardDAO.insertBoard(board); //게시글 추가하고나면 추가된 게시글번호 바로 가져오기 가능
		//System.out.println("게시글번호"+ board.getNum());게시글번호 잘 가져오는지 확인함
		if(file !=null && file.getOriginalFilename().length() != 0) {
			try { // 트라이 캐치로 감싸줌 : 예외처리
			String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			FileVO fileVo = new FileVO(board.getNum(), filename,file.getOriginalFilename());
			boardDAO.insertFile(fileVo);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("첨부파일 업로드 중 예외 발생");
			}
		}
	}

	@Override
	public int updateViews(Integer num) {
		// 다오에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardDAO.getBoard(num);
		//가져온 게시글이 있으면 가져온 게시글의 조회수를 1증가 시킴
		if(board !=null) {
			board.setViews(board.getViews()+1);
			//다오에게 게시글을 주면서 게시글을 수정하라고 요청
			return boardDAO.updateBoard(board);
		}
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board) {
		if(board == null) {
			return 0;
		}
		if(board.getValid() == null) {
			board.setValid("I");
		}
		return boardDAO.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		//다오에게 게시글 번호를 주면서 가져오라고 시킴
		BoardVO board = boardDAO.getBoard(num);
		if(board == null || user == null || !board.getWriter().equals(user.getId())) {
			return 0;
		}
		//가져온 게시글의 valid값을 D로 수정
		board.setValid("D");
		//다오에게 게시글 정보를 주면서 수정하라고 시킨 후 정수값을 리턴
		return boardDAO.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		
		return boardDAO.getTotalCount(cri);
	}
}
