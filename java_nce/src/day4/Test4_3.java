package day4;

import java.util.Scanner;

public class Test4_3 {

	public static void main(String[] args) {
		//정수를 거꾸로 출력하는 코드를 작성하세요. //@@@ 이거 다시해보기*********
		 /* 예시
		 * 정수를 입력하세요: 1234
		 * 결과 : 4321
		 * 정수를 입력하세요: 120
		 * 결과:021
		 * 반복횟수 : x(break문으로 종료하게끔)
		 * 규칙성 : num을 10으로 나눈 나머지를 출력
		 * 		  num에 num을 10으로 나눈 몫을 저장
		 * 		  num이 0이면 반복문을 종료
		 * 반복문 종료후 : 없음
		 * 1234=> 4를 출력 num =123
		 * 123 => 3을 출력 num=12
		 * 12 => 2를 출력 num=1
		 * 1 => 1을 출력 num=0
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num1 = scan.nextInt();
		System.out.print("결과: ");
		scan.close();
		
		for(;;) {
			System.out.print(num1%10);
			num1 = num1/10;				//@@@나눈 몫은 나머지%가 아니라 나눗셈연산자/로 쓰기 .0은 붙이면 안됨 @@@왜???
			if(num1==0) {
				break;
			}
			
		}
		/*입력된 정수값 1개를 어떻게 뒤집지? 방탈출잘하겟네...
		 * 처음시작을 */
		
		
	}

}
