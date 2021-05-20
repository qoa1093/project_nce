package day17;

import java.util.Scanner;

public class StringTest9 {

	public static void main(String[] args) {
		/*공백을 포함한 긴 문자열을 입력한 후 단어를 입력받아 해당 단어가 몇번 나오는지 확인하는코드를 작성하세요.
		 * 예시
		 * 문장입력 : Hello. Hi. HHHH. He. His
		 * 단어입력 : H
		 * 횟수 : 8번*/
		// 콘솔에서 문장을 입력받음
		//콘솔에서 단어를 입력받음
		//반복문을 통해 해당 단어가 몇번 있는지 체크(indexOf()를 통해서)
		Scanner scan = new Scanner(System.in);
		System.out.println("문장입력 : ");
		String str = scan.nextLine();
		System.out.println("단어입력 : ");
		String str2 = scan.next();
		int cnt = 0; //단어의 갯수
		int index = 0; //해당 단어가 있는 시작번지
		
		while(true) {
			//문장에 해당 단어가 있는 위치를 찾음
			index = str.indexOf(str2);
			if(index == -1) {
				break;
			}
			cnt++;
			str = str.substring(index+1);
		}
		System.out.println("횟수 : "+ cnt+ "번");

	}

}
