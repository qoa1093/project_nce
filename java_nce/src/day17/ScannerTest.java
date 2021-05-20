package day17;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		/* next() : 공백(엔터, 스페이스)을 만나기 전까지 문자열을 가져오는 메소드
		 * nextLine() : 처음만나는 엔터전까지 문자열을 가져오는 메소드
		 * */
		Scanner scan = new Scanner("1234 1234\n\n\n4567\n8910\n++++\n");
		while(scan.hasNext()) {						//다음에 내용이 있는지 없는지를 체크해줌
			String str = scan.nextLine();
			if(str.length() != 0) {
				System.out.println(str);
			}
		}
		/*String str = scan.nextLine();	//1234 1234 추출
		System.out.println(str);
		System.out.println("-----");
		str = scan.nextLine();			//4567 추출
		System.out.println(str);
		System.out.println("-----");
		int num = scan.nextInt();		//8910을 추출
		System.out.println(num);
		str = scan.nextLine();			//빈 공백을 추출. 넥스트라인이 아닌 위 정수에서 정수 가져가고 남은 역슬래시 \n을 추출함 
		System.out.println(str);
		System.out.println("-----");*/
		scan.close();					//공백을 가져가서 긴문장 추출 불가능

	}

}
