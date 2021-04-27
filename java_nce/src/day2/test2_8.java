package day2;

import java.util.Scanner;

public class test2_8 {

	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받아 입력받은 연산자에 맞는 연산 결과를 
		 * 출력하는 코드를 작성하세요.*/
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 연산자를 입력하세요(예:1+2): ");
		
		int num1 = scan.nextInt();
		char op = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		double result = 0;
		
		if (op == '+') {                    // @@@왜 ||는 넣으면 안될까?
			result = num1 + num2;
		}else if(op == '-') {
			result = num1 - num2;
		}else if(op == '*') {
			result = num1 * num2;
		}else if(op == '%') {
			result = num1 % num2;
		}else if(op == '/') {
			result = (double)num1 / num2;
		}
		System.out.println(""+ num1 + "" + op + ""+ num2 + "=" + result);
		scan.close();	
	  }
		
	 
	}

