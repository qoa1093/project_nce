package day2;

import java.util.Scanner;

public class Test2_3 {

	public static void main(String[] args) {
		/* 국어성적을 입력받고 국어 과목을 패스했는지 안했는지 확인하는 코드를 작성하세요.
		*국어 성적이 60점 미만이면 f, 국어 성적이 60점 이상이면 p*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("국어성적을 입력하세요: ");
		int kor = scan.nextInt();
		String result = (kor < 60) ? "Fail" : "Pass";
		System.out.println(result);
		
		/*System.out.println("국어 과목을 패스했습니까?"+(kor>=60));*/
		
		/*국어 성적이 a학점인지 아닌지를 판별하는 코드를 작성하세요.
		 * a학점은 90점이상 100점이하*/
		/*90<=kor<=100/거짓 <=100 비교가 되서 안됨
		90<=kor && kor<=100*/
		
		boolean result2 = 90 <= kor && kor <=100;
		System.out.println("국어 성적은 a학점인가? "+ result2);
		
		/*조건선택연산자를 통해 국어 성적의 학점을 출력하는 코드를 작성하세요*/
		
		String result3 = (90 <= kor && kor <= 100) ? "A" :
			(80<=kor && kor<90) ? "B":
				(70<=kor && kor <80) ? "C":
					(60<=kor && kor <70) ? "D":"F";
		System.out.println("국어성적 : "+ result3);
		
		
		scan.close();
	
	}

}
