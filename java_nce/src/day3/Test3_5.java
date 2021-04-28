package day3;

import java.util.Scanner;

public class Test3_5 {

	public static void main(String[] args) {
		/*월의 마지막 일수를 출력하는 예제를 switch문으로 작성하세요.
		 * 31: 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2/ 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하세요: ");
		int month = scan.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12: //month가 1,3,5,7,8,10,12일때 같은 실행문을 실행
			System.out.println(month + "월의 마지막날은 31일입니다.");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월의 마지막날은 30일입니다.");
			break; //month가 4, 6, 9,11일때 11에 해당하는 실행문을 실행 // 4,6,9일때는 실행문이 없음
		case 2:
			System.out.println(month + "월의 마지막날은 28일입니다.");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			
		}
		
		
		
		scan.close();
	}

}
