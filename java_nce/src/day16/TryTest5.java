package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryTest5 {

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
			
			double res = calculate(num1, ch, num2);
			
			System.out.println(num1 + " " + ch + " " + num2 + "=" + res);
		 
		}catch(InputMismatchException e) {
			System.out.println("잘못된 값을 입력했습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage()); // 여기서 가져오므로 두번 출력되지 않고 엘스 부분만 나오고 종료 출력됨
		}
		System.out.println("프로그램 종료");
		scan.close();
	}
	/* 기능 : 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수, 산술연산자 => int num1, chat ch, int num2
	 * 리턴타입 : 산술연산결과 => 실수 => double
	 * 메소드명 : calculate*/
	public static double calculate(int num1, char ch, int num2) {
		double res = 0.0;
		if(ch == '+') {
			System.out.println(num1 + '+' + num2 + '=' + num1 + num2);
		}else if(ch == '-') {
			System.out.println(num1 + '-' + num2 + '=' + num1 - num2);
		}else if(ch == '*') {
			System.out.println(num1 + '*' + num2 + '=' + num1 * num2);
		}else if(ch == '%') {
			// num2가 0인 경우 예외가 자동으로 발생하지만 if문과 throw를 쓰는 이유는 예외 메세지를 한글로 하고싶어서
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			 System.out.println(num1 + '%' + num2 + '=' + num1 % num2); 
		 }else if(ch == '/') {
			 //num2가 0이어도 실수/정수 라서 예외가 자동으로 발생하지 않기 때문에 예외를 발생시키기위해 조건문 if문과 throw를 사용
			 if(num2 == 0) {
					throw new ArithmeticException("0으로 나눌 수 없습니다.");
				}
			 System.out.println(num1 + '/' + num2 + '=' + (double)num1 / num2);
		 }else{
			 //잘못된 연산자가 들어오면 예외를 발생시킴
			throw new RuntimeException("잘못된 연산자 입니다."); //throws가 없더라도 떠넘기기임 안에 실행예외 런타임이라서?
		}
		return res;
	}

}
