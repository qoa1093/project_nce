package day3;

import java.util.Scanner;

public class For6 {

	public static void main(String[] args) {
		/*정수의 약수를 출력하는 코드를 작성하세요
		 * 정수를 입력하세요 : 6
		 * 1 2 3 6
		 * 정수 : num
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 			초기화 : i는 1부터
		 * 			조건식 : i는 num까지, i는 num보다 작거나 같다
		 * 			증감식 : i를 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 * 			=> num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		
		int j = scan.nextInt();					//i는 j의 약수 나열,
		int k = scan.nextInt();
		int i;
		
		for(i=1; i<=j; i+=1) {
			if(j % i== 0){
				System.out.print(i + " ");
			}		
		}
		
		/*
								 
		for(i=1; i<=k; i+=1) {
			if(k % i== 0){
				System.out.println(i);
			}
		}
		*/
		
		
		/*두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 6의 약수 : 1 2 3 6
		 * 8의 약수 : 1 2 4 8
		 * 12의 약수 : 1 2 3 4 6 12
		 * 8과 12의 공약수 : 1 2 4
		 * 최대공약수 : 공약수 중 가장 큰 수
		 * 8과 12의 최대 공약수 : 4*/
		
		/*int i,j;
		
		i = 6;
		/*if(i % 2 == 0){
			System.out.println(i);
		}
		
		if (i<=j){
		for(i=1; i;i++)
		
		}*/
		
		/*for(i=1;;) {
			i%2==0
				
			
		}*/
		

	}

}
