package day2;

import java.util.Scanner;

public class Test2_7 {

	public static void main(String[] args) {
		/*평년의 월의 마지막 일수를 출력하는 코드 작성
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * */
		System.out.print("월을 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if (num == 1 ||num == 3||num == 5||num == 7||num == 8||num == 10||num == 12){
			System.out.println(num + "은 31일까지 있습니다.");
			
		}else if(num == 4 ||num == 6||num == 9||num == 11){
			System.out.println(num + "은 30일까지 있습니다.");
		}else if(num == 2){
			System.out.println(num + "은 28일까지 있습니다."); //@@@왜 if 넣어야하지?
		}
		scan.close();

	}

}
