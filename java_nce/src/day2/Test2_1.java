package day2;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		
		
		double korScore, engScore, matScore;
		System.out.print("국어, 영어, 수학성적을 입력하세요: ");
		Scanner scan = new Scanner (System.in);
		korScore = scan.nextDouble();
		engScore = scan.nextDouble(); 
		matScore = scan.nextDouble();
		
		System.out.println("국어:"+korScore+"점");
		System.out.println("영어:"+engScore+"점");
		System.out.println("수학:"+matScore+"점");
		/*/국어, 영어, 수학 성적을 입력받아 출력해보세요.
		*단 성적은 0~100 사이의 실수 */
		
		
	}

}
