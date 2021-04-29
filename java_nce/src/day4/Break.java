package day4;

import java.util.Scanner;

public class Break {

	public static void main(String[] args) {
		//break : 반복문 종료 키워드(반드시 if문과) @@@얘도 다시보기 오늘은 다 다시봐야겠네
		/**/
		int i;
		for(i=1; i<=5; i+=1) {
			System.out.println("Hello");
			//if문 없이 break가 나오면 반복문을 쓴 의미가 없어짐.
			break;
		}
		 
		
		for(i=1; ; i+=1){
			System.out.println(i);	//@@@ 헷갈려: >=로 표현시 브레이크문 먼저 실행하고 마지막에 출력
			if(i==5) {				//@@@ 아 이거 왜냐면 위에서 무한으로 돌아가고 출력->건너뛰기->출력이라서
				break;
			}
		}
		char ch;
		Scanner scan = new Scanner(System.in);
		for(;;){
			System.out.print("문자를 입력하세요(종료하려면 q/Q입력): ");
			ch = scan.next().charAt(0);
			if(ch=='q' || ch =='Q') {
				break;
			}
		}
		scan.close();

	}

}
