package accountbook;

import java.util.Scanner;

public class AccountBookTest {

	public static void main(String[] args) {
		/* 가계부 프로그램 구현하려고 한다. 이때 필요한 클래스를 만들어보세요.
		 * 지출 입금 잔액 지출타입?(식비 등등...)// 고정지출 저번달 지출비교(메소드??) 
		 * 수입 : 수입/지출				< int로 받아서 계속 더하기(각각 수입따로 보여주나? 아님 총액?)
		 * 날짜 :						< 이것도 입력받아서 그대로... 변경사항없음
		 * 자산 : 현금/ 은행/ 카드/		< 자산은 문자열 타입.. 각각 변수선언하고 숫자로 선택해서 리턴하게..? 스위치문?
		 * 분류 : 식비/ 교통/ 건강/ 		< 위랑 비슷? 뭔가 배열써야할거같은데
		 * 금액 : 					< int로 받아서 어딘가에 저장해둬야할거같음
		 * 내용 : 					< 문자열
		 * */ 
		//###next는 공백을 인식하기 때문에 날짜를 띄어쓰면 뒷 숫자부분이 다음 스캔입력값으로 들어감
		AccountBookProgram2 abp = new AccountBookProgram2();
		
		AccountBookProgram2 abp2;
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int subMenu = 0;
		do {
			abp.printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:		abp.insert();		break;
			case 2:		abp.update();		break;
			case 3:		abp.delete();		break;
			case 4:		
				abp.printSubMenu();
				subMenu = scan.nextInt();
				switch(subMenu) {
				case 1: abp.printItemListDetail(); break;
				case 2: abp.printItemListSimple(); break;
				case 3: abp.printItem();		   break;
				case 4: abp.printTotal();		   break;
				default:	System.out.println("잘못된 메뉴"); break;
				}
				break;
			case 5:
				System.out.println("프로그램 종료"); 	break;
			default:
				System.out.println("잘못된 메뉴");
			}
		}while(menu !=5);
		
		
		/*do {
			//abp.메뉴출력();
			System.out.println();
			System.out.println("메뉴 번호를 입력하세요."
					+ '\n'+"1. 내역 추가"
					+ '\n'+"2. 내역 수정 "
					+ '\n'+"3. 내역삭제 "
					+ '\n'+"4. 내역전체 자세히 확인 "
					+ '\n'+"5. 내역전체 간략히 확인 "
					+ '\n'+"6. 선택한 내역만 확인 "
					+ '\n'+"7. 총 금액 출력"
					+ '\n'+"8. 종료");
			
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				abp.insert();
				break;
			case 2:
				abp.update();
				break;
			case 3:
				abp.delete();
				break;
			case 4:
				abp.printItemListDetail();
				break;
			case 5:
				abp.printItemListSimple();
				break;
			case 6:
				abp.printItem();
				break;
			case 7:
				abp.printTotal();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}while(menu !=8);*/

	}

}



