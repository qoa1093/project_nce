package day8;

import java.util.Scanner;

public class Test8_5 {

	public static void main(String[] args) {
		/*10개 짜리 배열에 1부터 10을 저장한 후 출력하는 코드를 작성하세요.*/ 
		int arr[] = new int[10];
		for(int i=0;i<10;i+=1) {
			arr[i] = i+1;				//arr[i]=i+1 arr[i+1] i+1+1 arr[i+2]  
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		/*10개짜리 배열에 피보나치수열을 저장한 후 출력하는 코드를 작성하세요.
		 * 피보나치 수열
		 * 앞에 두개를 더하여 나열함
		 * 0번지 : 1 1번지 : 1
		 * - 1 1 2 3 5 8 13 21 34 55*/
		int arr2[] = new int[10];
		arr2[0]= arr2[1] = 1;
		//피보나치 수열 값을 배열에 저장
		for(int i=2;i<arr2.length;i+=1) {
			arr2[i] = arr2[i-2] + arr2[i-1];
		}
		for(int i=2;i<arr2.length;i+=1) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		/*5개 짜리 배열에 저장된 숫자들 중 연속된 3자리 숫자가 있는지 확인하는 코드를 작성하세요. 
		 * 단, 숫자들은 정렬되었다고 가정
		 * 예시
		 * 입력 : 1 1 2 3 4
		 * 연속
		 * 예시
		 * 입력 : 1 2 4 5 8
		 * 연속아님
		 * 입력 : 1 3 5 7 8
		 * 연속아님*/
		
		Scanner scan = new Scanner(System.in);
		int num[] = new int[5];
		
		for(int i=0;i<5;i+=1) {
		 num[i] = scan.nextInt();
		}
		
		int cnt=1;
		for(int i=1;i<num.length-1;i+=1) {
			if(num[i-1]==num[i]-1) {
				//i번지의 값과 i 번지의 값의 차이가 1이면 cnt를 1 증가
				if(num[i]+1 ==num[i+1]) {
					cnt +=1;
				}
				else {
					cnt = 1;
				}
				//아니면 cnt를 1로 초기화
				//count가 3이면 반복문 종료
				if(cnt==3) {
					break;
				}
			}
			
		}
		if(cnt==3) {
			System.out.println("연속");
		}else {
			System.out.println("연속아님");
		}
	}

}
