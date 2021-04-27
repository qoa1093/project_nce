package day2;

import java.util.Scanner;

public class if_2 {

	public static void main(String[] args) {
		/*변수 num에 정수를 입력받아 
		 * 입력받은 정수가 짝수이면 
		 * 짝수라고 출력하는 코드를 작성하세요.*/
		System.out.print("양의 정수를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num % 2 == 0) { 
			System.out.println("짝수");
			}else {
			System.out.println("홀수");
		}
		/*정수가 짝수이다->(num)를 (2)로 (나누었을때 나머지)가 0과 (같다)*/
		
		/*입력받은 정수가 홀수이면 홀수라고 출력하는 코드를 작성하세요.*/
		/*if (조건식:정수가 홀수이다){
		 * 실행문(홀수라고 출력);
		 * }
		 * 정수가 홀수이다 => num을 2로 나누었을때 나머지가 1과 같다
		 * =>(num % 2 == 1)
		 * */
	}

}
