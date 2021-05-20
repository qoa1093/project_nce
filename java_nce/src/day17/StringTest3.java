package day17;

import java.util.Scanner;

public class StringTest3 {

	public static void main(String[] args) {
		System.out.println("abcdef".indexOf("bc"));	//시작하는 번지를 알려줌
		System.out.println("abcdef".indexOf("ad"));
		/*두 단어 단어 a와 단어 b를 입력받고 단어 a에 단어 b가 있는지 없는지 확인하는 코드를 작성*/
		Scanner scan = new Scanner(System.in);
		System.out.println("두 단어를 입력하세요 : ");
		String str1 = scan.next();
		String str2 = scan.next();
		
		if(str1 != null && str1.indexOf(str2) != -1) {
			System.out.println(str1+"에 "+str2+"가 포함되어 있음");
		}else {
			System.out.println(str1+"에 "+str2+"가 포함되지 않음");
		}
		if(str1 != null) {
			System.out.println(str1+"의 길이 : "+str1.length());
		}
		scan.close();

	}

}
