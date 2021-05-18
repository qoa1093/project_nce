package day16;

import java.util.Scanner;

public class TryTest4 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요. */ //나중에 필기 다시하기
		int num1;
		int num2;
		char ch;
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		
		try {
			num1 = scan.nextInt();
			ch = scan.next().charAt(0);					//throw :  내가 임의로 예외발생시키고 싶을때 예: ?
			num2 = scan.nextInt();
			
			/*try {
				 if(ch == '/') {
					 System.out.println(num1 + '/' + num2 + '=' + (double)num1 / num2); //실수가 될때? 0으로 나눌때?
				 }
			}catch(Exception e) {
				System.out.println("예외");
				return;
			}
			try {
				 if(ch == '%') {
					 System.out.println(num1 + '%' + num2 + '=' + num1 % num2); 
				 }
			}catch(Exception e) {
				System.out.println("예외");
				return;
			}*/
			
			if(ch == '+') {
				System.out.println(num1 + '+' + num2 + '=' + num1 + num2);
			}else if(ch == '-') {
				System.out.println(num1 + '-' + num2 + '=' + num1 - num2);
			}else if(ch == '*') {
				System.out.println(num1 + '*' + num2 + '=' + num1 * num2);
			}else if(ch == '%') {
				 System.out.println(num1 + '%' + num2 + '=' + num1 % num2); 
			 }else if(ch == '/') {
				 System.out.println(num1 + '/' + num2 + '=' + (double)num1 / num2); //실수가 될때? 0으로 나눌때?
			 }else{
				
				throw new Exception("잘못된 연산자 입니다."); //이부분 문자열을 
			}
		 
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage()); // 여기서 가져오므로 두번 출력되지 않고 엘스 부분만 나오고 종료 출력됨
		}
		System.out.println("프로그램 종료");
		scan.close();
	}
	

}
