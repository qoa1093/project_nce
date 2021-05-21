package day18;

import java.util.ArrayList;
import java.util.Scanner;

public class ListTest2 {

	public static void main(String[] args) {
		/* 오늘의 할일을 저장하는 리스트를 생성한 후 오늘의 할일을 입력받고 다 받은 후에 출력하는 코드를 작성하세요. 
		 * 오늘의 할일은 종료를 입력하면 입력을 종료하고 출력하면 됩니다.
		 * 예시>
		 * 오늘의 할일 입력 : 출근
		 * 오늘의 할일 입력 : 오전수업
		 * 오늘의 할일 입력 : 종료
		 * 오늘의 할일
		 * 1. 출근
		 * 2. 오전수업
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> today = new ArrayList<String>();
		String day;
		
		while(true){
			System.out.print("오늘의 할일 입력 : ");
			day = scan.next();
			if(day.equals("종료")) {		//do while로 하고 조건으로 빼면 마지막에 입력한 값을 넣고 ->참거짓 비교하고 ->참일시 종료하기 때문에 안됨
				break;
			}
			today.add(day);
			
		}
		scan.close();
		System.out.println("오늘의 할일");
		for(int i =0;i<today.size();i++) {
			System.out.println((i+1)+".	"+today.get(i));
		}
		
		

		
		
		
	}

}
