package kr.green.spring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	//private String uploadPath = "C:\\Users\\chaennn\\Desktop\\JAVA_NCE\\JAVA_NCE\\project_nce\\uploadfiles";

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
	public void insertBoard(BoardVO board,  MultipartFile [] file){
		//다오에게 게시글 정보를 주면서 게시글 등록하라고 시킴
		boardDAO.insertBoard(board); //게시글 추가하고나면 추가된 게시글번호 바로 가져오기 가능
		if(file == null)
			return;
		for(MultipartFile tmp : file)
			//System.out.println("게시글번호"+ board.getNum());게시글번호 잘 가져오는지 확인함
			insertFileVO(tmp, board.getNum());
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
	public int updateBoard(BoardVO board, MultipartFile file) {
		if(board == null || board.getNum() <= 0) {
			return 0;
		}
		if(board.getValid() == null) {
			board.setValid("I");
		}
		/*
		FileVO fileVo = boardDAO.getFileVO(board.getNum());
		//첨부파일이 추가되는 경우
		if(fileVo == null && (file != null && file.getOriginalFilename().length() != 0)) {
			insertFileVO(file, board.getNum());
		}				
		//첨부파일이 삭제되는 경우
		else if(fileVo != null && (file != null && file.getOriginalFilename().length() == 0)) {
			//업로드 되었던 파일을 삭제
			deleteFileVO(fileVo);
		}
		//첨부파일이 수정되는 경우
		else if(fileVo != null &&(file != null && file.getOriginalFilename().length() != 0)) {
			//업로드 되었던 파일을 삭제
			deleteFileVO(fileVo);
			insertFileVO(file, board.getNum());			
		}*/
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
		//첨부파일 삭제
		//1.해당 게시글과 일치하는 첨부파일 정보들을 가져옴
		ArrayList<FileVO> fileList = boardDAO.getFileVOList(num);
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmp : fileList) {
				deleteFileVO(tmp);
			}
		}
		//2.반복문으로 하나씩 삭제처리
		
		//다오에게 게시글 정보를 주면서 수정하라고 시킨 후 정수값을 리턴
		return boardDAO.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		
		return boardDAO.getTotalCount(cri);
	}
	@Override
	  public ArrayList<FileVO> getFileVOList(Integer num){
	   if(num == null)
	   	return null;
	 return boardDAO.getFileVOList(num);
	  }

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		 try{
		        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
		        HttpHeaders headers = new HttpHeaders();
		        in = new FileInputStream(uploadPath+fileName);
		        fileName = fileName.substring(fileName.indexOf("_")+1);
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.add("Content-Disposition",  "attachment; filename=\"" 
					+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
		        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		    }catch(Exception e) {
		        e.printStackTrace();
		        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		    }finally {
		        in.close();
		    }
		return entity;
	}
	//메소드만들기
	//파일을 서버에 업로드한 후 num게시글에 db애 추가하는 메소드
	private void insertFileVO(MultipartFile file, int num) {
		if(file !=null && file.getOriginalFilename().length() != 0) {
			try { // 트라이 캐치로 감싸줌 : 예외처리
				String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(num, filename,file.getOriginalFilename());
				boardDAO.insertFile(fileVo);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("첨부파일 업로드 중 예외 발생");
			}
		}
	}
	//서버에 업로드 된 파일을 삭제 후 db에 삭제처리하는 메소드
	private void deleteFileVO(FileVO file) {
		File ftmp = new File(uploadPath+file.getName());
		if(ftmp.exists()) {
			ftmp.delete();
		}
		boardDAO.deleteFileVO(file.getNum());
	}
}
