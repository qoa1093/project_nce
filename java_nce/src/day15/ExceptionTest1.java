package day15;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두정수를 입력하세요: ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		if(num2 !=0) {
		int res = num1 % num2;
		System.out.println(num1+"을"+num2+"로 나눈 나머지 : "+res);
		}else{
			System.out.println("0으로 나눌 수 없습니다.");
		}
			scan.close();
		
	}
	//10 0 : 예외가 발생한 경우 -> else문 추가해서 해결 : 조건문등 코드로 예외가 발생하지 않도록 해결하는 것을 예외 처리라고 함
}
