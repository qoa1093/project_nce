package day2;

import java.util.Scanner;

public class Test2_2 {

	public static void main(String[] args) {
		/*두 정수를 입력받아 입력받은 두 정수의 산술 연산 결과를 출력하는 예제
		 * 예시
		 * 두 정수를 입력하세요 : 12
		 * */
		//또는 int num1, num2; 로 선언하기
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 :");
		int num1 = scan.nextInt(); // 변수선언..
		int num2 = scan.nextInt();
		
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		System.out.println(num1 + "/" + num2 + "=" + (double)(num1 / num2));
		System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));

		/*Scanner scan = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요 :");
		int a, b;
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println("1 + 2 = " + a + b);
		System.out.println("1 - 2 = " + (a - b));
		System.out.println("1 * 2 = " + a * b);
		System.out.println("1 / 2 = " + (double)(a / b));
		System.out.println("1 % 2 = " + (a % 2)); */
		//@@@ 이해 안감... 왜 그냥 에이랑 비넣으면 안되지 유니코드 그거때문인가 엉엉
	}

}
