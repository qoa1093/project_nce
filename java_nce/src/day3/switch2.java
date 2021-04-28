package day3;

import java.util.Scanner;

public class switch2 {

	public static void main(String[] args) {
		/* 계절을 영어로 입력받아 입력받은 계절을 한글로 출력하는 예제
		*/
		
		Scanner scan = new Scanner(System.in);
		System.out.println("계절을 영어로 입력하세요 : ");
		
		String season;
		
		season = scan.next();
		
		switch(season) {
		case "spring":
			System.out.println("봄");
			break;
		case "summer":
			System.out.println("여름");
			break;
		case "fall":
			System.out.println("가을");
			break;
		case "winter":
			System.out.println("겨울");
			break;
		default:
			System.out.println("땡! 계절을 영어로 다시 입력하세요.");
		}
		
		
		
		scan.close();
	}

}
