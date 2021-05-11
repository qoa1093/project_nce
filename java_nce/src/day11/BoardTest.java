package day11;

import board.Board;

public class BoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board(1, "제목입니다"	, "내용입니다", "전일규", "2021-05-11", "공지");
		board.print();
		//에러 : String str = new Point(); int num = str;
		String str = "1";
		/* =는 오른쪽에 있는 값을 왼쪽에 저장하는데, 타입이 같거나 변환이 가능해야한다. 정수 -> 실수는 형변환 가능해서 가능..*/
		double dnum = 1;
		int num = (int)1.0; //실수 1.0이 강제 타입변환 되어서 가능
	}

}
