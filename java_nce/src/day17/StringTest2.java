package day17;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		System.out.println("홍길동".equals("홍길동")); //문자열 상수에 바로 이퀄스 사용가능(반드시 string객체가 아니어도)
		/* 두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		System.out.println("두 단어 입력하기 : ");
		String str1 = scan.next();
		String str2 = scan.next();
		if(str1!= null && str1.equals(str2)) {
			System.out.println("같은단어"); // ("단어 " + str1 + "과(와) 단어 " + str2 + "는 같음")
		}else {
			System.out.println("다른단어");
		}
		System.out.println(str1.equals(str2));
		scan.close();
	}

}
