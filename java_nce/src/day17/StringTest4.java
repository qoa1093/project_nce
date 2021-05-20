package day17;

import java.util.Scanner;

public class StringTest4 {

	public static void main(String[] args) {
		System.out.println("콜라는 귀여워".replace("콜라", "cola"));
		/* 문자열 c를 입력받고 해당 문자열에서 교체할 문자열 a와 문자열b를 입력받아 문자열 c에 있는 문자열 a를 b로 바꾸는 코드 작성 */
		Scanner scan = new Scanner(System.in);

		System.out.println("문자열을 입력하세요(예:콜라는귀여워):");
		String c = scan.next();
		System.out.println(c);
		System.out.println("수정할 부분과 수정내용을 입력하세요(예:콜라 고양이) : ");
		String a = scan.next();
		String b = scan.next();
		if(c!=null && c.indexOf(a)!= -1) {
			System.out.println(c.replace(a, b));
		}else {
			System.out.println(c+"에서 "+a+"는 없는 부분입니다.");
		}
	
	
	}
	
	

}
