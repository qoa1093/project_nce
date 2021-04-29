package day4;

public class Test4_1 {

	public static void main(String[] args) {
		/* 11부터 20까지 출력하는 코드를 작성하세요 					//#아래에 3, 6, 9 코드 있음 확인해볼것.
		 * 반복횟수 : i는 11부터 i는 20보다 작거나 같을때까지 i는 1씩 증가
		 * 규칙성 : 
		 * 반복문 종료 후 :
		 * */
		
		int i;
		for(i=11;i<=20;i+=1){
			System.out.print(i+" ");
		}
		
		System.out.println('\n');
		
		/*20부터 11까지 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 20부터 i는 11보다 크거나 같을때까지 i는 1씩 감소
		 * 규칙성 : i를 출력
		 * 반복문 종료 후 : 없음*/
		
		
		for(i=20;i>=11;i-=1) {
			System.out.print(i+" ");
		}
		
		System.out.println('\n');
		
		
		
		
		
		
		
		/*1부터 100까지 숫자 중 일의 자리가 3, 6 9로 끝나는 수들을 출력하는 코드를 작성하세요.*/ //@@@얘는 한번더보기

		/*1차작성코드:
		 * int k, num;
		for(k=1;k<=100;k+=1) {
			if(k % 10 == 3) {
				System.out.print(k+" ");
			}else if(k % 10 == 6) {
				System.out.print(k+" ");
			}else if(k % 10 == 9) {
				System.out.print(k+" ");
			}*/
		
		int k;
		for(k=1;k<=100;k+=1) { 
			if(k % 10 == 3||k % 10 == 6||k % 10 == 9) {
				System.out.print(k+" ");
				k+=3;
				System.out.print(k+" ");
				k+=3;
				System.out.println(k+" ");
			}
			
			/*@@@ num 안써도 됨: 왜냐면 for7문에서는 두개의 변수의 공약수를 구하는 거였고 
			 * 				  이건 한개의 변수내에서 여러값을 찾는것이기 때문임.
			 * 				  굳이 새변수를 넣어서 서로다른 두 변수의 값을 통합할 필요가 없음*/
			
			
			//강사님 코드
			int m; //출력된 숫자의 갯수
			for(k=1, m=0 ; k<=100 ; k+=1) { 
				if(k % 10 == 3||k % 10 == 6||k % 10 == 9) {
					System.out.print(k+" ");
					m+=1;
					if(m % 3 == 0) {			//m이 세번째 올때마다 엔터
						System.out.println();
					}
						
					}
				}
			
		}
		
		

	}

}
