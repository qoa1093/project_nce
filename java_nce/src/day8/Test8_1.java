package day8;

import java.util.Scanner;

public class Test8_1 {

	public static void main(String[] args) {
		/*1~9 사이의 정수를 입력받아 각 수자가 몇번 입력됐는지 출력하는 코드를 작성하세요,
		 * -1이 입력되면 입력종료하고 각 숫자가 몇번 입력됐는지 출력
		 * 예시
		 * 입력 : 1
		 * 입력 : 1
		 * 입력 : 9
		 * 입력 : 3
		 * 입력 : 2
		 * 입력 : -1
		 * 1 : 2번
		 * 2 : 1번
		 * 3 : 1번
		 * 4 : 0번 
		 * 5 : 0번
		 * 6 : 0
		 * 7 : 0
		 * 8 : 0
		 * 9 : 1번*/ 
		
		int min = 1, max = 9, num;
		int arr[]=new int[10];
		
		Scanner scan = new Scanner(System.in);
		
		 do{
			System.out.print("숫자를 입력하세요: ");
			num = scan.nextInt();
			
			if(num == -1) {
				break;
			}
			arr[num] += 1;
			
		}while(num !=-1);
		
		 for(int i=1;i<=9;i+=1) {
				System.out.println(i+":" +arr[i]+ "번 ");
			
		}
		System.out.println();
		
		/* 강사님 코드
		 * int num;
		 * Scanner scan = new Scanner(System.in);
		 * while(true){
		 * 	System.out.print("숫자를 입력하세요(1~9): ");
		 * 	num = scan.nextInt();
		 * 	if(num == -1){						// == if(num<1 || num>9))
		 * 		break;
		 * 	}
		 *  arr[num] += 1;
		 * }
		 * for(int i=1;i<=arr.length;i+=1) {
			System.out.println(i+":" +arr[i]+ "번 ");
		   }
		   System.out.println();
		 * scan.close();
		 * 	*/

	}

}
