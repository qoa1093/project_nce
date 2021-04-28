package day3;

import java.util.Scanner;

public class Test3_2 {

	public static void main(String[] args) {
		/*정수를 입력받아 입력받은 정수가 0, 양수, 음수인지 판별하는 코드를 작성하세요.*/
		
		System.out.println("정수를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if(num == 0){
			System.out.println("0입니다.");
		}else if(num > 0) {
			System.out.println("양수입니다.");
		}else {
			System.out.println("음수입니다.");
		}
		scan.close(); // 없으면 스캔에 노란줄 그어짐. 없어도 동작은 한대~

	}

}
