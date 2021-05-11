package board;

import java.util.Scanner;

public class BoradTest {

	public static void main(String[] args) {
		/* 다음 메뉴를 가지는 게시글 콘솔 프로그램을 만드세요.
 			게시글 등록
 			게시글 수정
 			게시글 삭제
 			게시글 목록 확인(전체)
 			게시글 상세 확인(한개)
 			프로그램 종료*/
		//반복문을 이용하여 메뉴를 출력하고 메뉴를 선택하는 작업, 프로그램 종료를 선택할 때까지
		
		
		Scanner scan = new Scanner(System.in);
		int i= 0;
		int menu = 0;
		do {
			i = scan.nextInt();
			switch(i) {
			case 1:
				System.out.println("게시글 등록");
			case 2:
				System.out.println("게시글 수정");
			case 3:
				System.out.println("게시글 삭제");
			default:
				System.out.println("잘못된 입력");
			}
		}while(i != 6);
		System.out.println("프로그램 종료");
		/*선생님 코드
		 * 메뉴를 출력
		 * 메뉴를 선택
		 * 선택한 메뉴에 따라 기능 안내문 출력(switch문 이용 후 break;)*/
		
		
		/*switch(i) {
		case 1:
			System.out.println("게시글 등록");
		case 2:
			System.out.println("게시글 수정");
		case 3:
			System.out.println("게시글 삭제");
		
		}*/
		
		
		

	}

}
