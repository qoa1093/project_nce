package day17;

import java.util.Scanner;

public class StringTest5 {

	public static void main(String[] args) {
		String str = "안녕하세요";
		//2번지부터 마지막 번지까지 부분문자열 생성
		System.out.println("안녕하세요".substring(2));
		//원본을 수정하는 것이 아니라 새로운 문자열을 생성함
		System.out.println(str);
		//2번지부터 3번지전까지인 2번지까지 새로운 부분 문자열을 생성
		System.out.println(str.substring(2, 3));
		/*주민등록번호를 입력해서 생년원일 부분을 추출하여 연도, 월 일을 출력하는 코드를 작성하세요.
		 * 예시 
		 * 주민 번호 - 020101-3234567
		 * 주민 번호 :
		 * */
		 
		Scanner scan= new Scanner(System.in);
		System.out.println("주민번호를 입력하세요(-빼고 입력하세요):");
		String str1 = scan.next();
		//str1 = str1.substring(0, 6);
		
		//System.out.println(str1.substring(0,2)+"년"+str1.substring(2,4)+"월"+str1.substring(4,6)+"일");
		
		String year = str1.substring(0,2);
		String month = str1.substring(2,4);
		String day =  str1.substring(4,6);
		String num = str1.substring(6,7);
		//char gender = str.charAt(6);
		
		if(num.equals("1")||num.equals("2")) {
			year += "19";
			System.out.println(year +"년"+ month +"월"+ day+"일");
		}else if(num.equals("3")||num.equals("4")) {
			year += "20";
			System.out.println(year +"년"+ month +"월"+ day+"일");
		}else {
			System.out.println("잘못된 입력");
		}
		//성별 번호에 따라 year앞에 19또는 20을 붙이면 됨
		scan.close();
	}

}
