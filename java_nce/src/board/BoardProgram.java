package board;

import java.util.Scanner;

public class BoardProgram {
	private Board []board;
	private Scanner scan;
	private int count;
	public BoardProgram() {
		//board = new Board[10];
		//scan = new Scanner(System.in);
		this(10);
	}
	public BoardProgram(int max) {
		if(max <= 10) {
			max = 10;
		}
		board = new Board[max];
		scan = new Scanner(System.in);
	}
	/* 기능	  : 게시글을 추가하는 기능
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음
	 * 메소드명 : insertBoard
	 * */
	
	/* 기능	  : 게시글 번호를 입력받아 입력받은 게시글을 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardDetail */
	
	/* 기능	  : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList */
	
	/* 기능	  : 수정할 게시글번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : modifyBoard
	 * */
	
	/* 기능	  : 게시글 번호를입력받아 삭제하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음=>void
	 * 메소드명 : deleteBoard
	 * */
	
	/* 기능	  : 게시글 프로그램을 종료하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음=>
	 * 메소드명 : closeBoard
	 * */

}
