package day1;

import java.util.Scanner; //다른 파일가져오는역할명령어

public class input {

	public static void main(String[] args) {
		/*콘솔창에서 입력받아 변수에 저장하는 예제*/
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt(); //입력값 읽어와서 num에 저장시킴
		System.out.println("입력받은 값 : " + num);
		
		System.out.print("실수를 입력하세요: ");
		double dnum = scan.nextDouble(); //입력값 읽어와서 dnum에 저장시킴
		System.out.println("입력받은 값 : " + dnum);
		
		
		System.out.print("문자를 입력하세요: ");
		char ch = scan.next().charAt(0); // next().charAt(0) 명령어 변경
		/*scan.next(): 공백을 제외한 문자열을 읽어옴
		*문자열.charAt(0): 해당 문자열 중에 첫번째 글자를 읽어옴 */
		System.out.println("입력받은 값 : " + ch);
		
		System.out.print("문자열을 입력하세요: ");
		/* nextLine() : 공백을 포함한 문자열을 가져옴 */
		String str1 = scan.next(); //입력값 읽어와서 str1에 저장시킴
		System.out.println("입력받은 값 : " + str1);
		
		scan.close();


	}

}
