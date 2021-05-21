package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest2 {

	public static void main(String[] args) {
		/* 중복되지 않는 5개의 수가 입력될때까지 입력한 후 입력이 완료되면 종료하는 코드를 작성하세요.
		 * 예시
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 2
		 * 정수를 입력하세요 : 3
		 * 정수를 입력하세요 : 4
		 * 정수를 입력하세요 : 5
		 * 입력된 정수 : 1 2 3 4 5(출력은 순서상관 x)*/
		
		HashSet<Integer> num1 = new HashSet<Integer>();	//Integer : 문자열을 정수로 바꿔주는 타입변환 그거..?
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {	//while(num1.size() < 5) : num1의 크기가 5개가 되기전에 멈춤
			
			System.out.print("정수를 입력하세요 : ");
			int num2 = scan.nextInt();			//set.add(scan.nextInt()); : 한줄로 줄여쓰기 가능
			num1.add(num2);
			if(num1.size()==5) {
				break;
			}
			
		}
		System.out.print("입력된 정수 : ");
		Iterator<Integer> it = num1.iterator();	//Iterator : 번지가 없는 set같은 경우 값을 가져오기 위해 사용하는 클래스. 
		while(it.hasNext()) { 					//num1.iterator() : 인터페이스로 구현한 클래스의 객체
			Integer tmp = (Integer)it.next();	
			System.out.print(tmp+" ");			//(it.next() + " ") : 한줄로 줄여쓰기 가능
		}
		

	}

}
