package day3;

import java.util.Scanner;

public class Test3_4 {

	public static void main(String[] args) {
		/*두 정수와 산술연산자를 입력받아 계산 결과를 불력하는 예제를 switch문으로 작성하세요.*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("계산할 두 정수와 산술연산자를 입력하시오: ");
		
		int num1 = scan.nextInt(); 
		char op = scan.next().charAt(0); /*@@@이거 맨날 까먹음 넥스트 다음에 앳임!!!*/
		int num2 = scan.nextInt();
		
		//연산자에 따라서 계산방식이 달라지는걸 목표로 하기 때문에 op를 중심으로
		switch(op) {			//@@@두 정수가 바뀌면 값이 달라지고 계산방식은 똑같음 // 같다( ==)를 기준으로 동일하게 반복되는 op가 스위치의 변수위치, 달라지는 오른쪽이 값으로 감
		case '+':
			 System.out.println(""+num1 + op + num2 + " = " + (num1 + num2));
			break; //없으면 아쉬웡 끝까지 간다규
		case '-':
			System.out.println(""+num1 + op + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println(""+num1 + op + num2 + " = " + (num1 * num2));
			break;
		case '%':
			System.out.println(""+num1 + op + num2 + " = " + (num1 % num2));
			break;
		case '/':
			System.out.println(""+num1 + op + num2 + " = " + ((double) num1 / num2));
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
		
		}
		scan.close();
	}

}
