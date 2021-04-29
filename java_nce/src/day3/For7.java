package day3;

import java.util.Scanner;

public class For7 {

	public static void main(String[] args) {
		// 최대공약수 구하는 문제					@@@숫자 약하니까 다시보기
		
		/*두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 6의 약수 : 1 2 3 6
		 * 8의 약수 : 1 2 4 8
		 * 12의 약수 : 1 2 3 4 6 12
		 * 8과 12의 공약수 : 1 2 4
		 * 최대공약수 : 공약수 중 가장 큰 수
		 * 8과 12의 최대 공약수 : 4
		 * 
		 * 두 정수 : j, k 			//한쪽을 기준으로 1씩 증가만 체크해도 됨. 기준j보다 더 큰 공약수는 없음
		 * 반복횟수 : i는 1부터 j까지 1씩 증가 
		 * 규칙성 : i가 j의 약수이고 i가 k의 약수이면 i를 변수 gcd에 저장
		 * 			=> j를 i로 나누었을때 나머지가 0과 같고
		 * 				k를 i로 나누었을 때 나머지가 0과 같다면
		 * 				i를 변수 gcd에 저장
		 * 반복문 종료 후 :
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		
		int j = scan.nextInt();					
		int k = scan.nextInt();
		int i, gcd = 1;
		
		for(i=1; i<=j; i+=1) {
			if(j % i== 0 && k % i == 0){
				gcd = i;				
			}
		}
		System.out.println(j+"과"+k+"의 최대 공약수: "+gcd);
		/*i는 j의 약수 나열, j와 k의 크기가 서로 달라도 if문에서 앤드연산자로 잡아줌
		 * :더 작은값의 최댓값이 최종 i의 값
		 * i의 축적을 새 변수 gcd로 저장함. 
		 * @@@이때 초기값 범위를 지정해주어야함(gdc=1)
		 * @@@결과값 for문 동작 끝나는 괄호 다음에 최종 1개 내기
		 *   */
	}
}
			 		
	
		

/*for(i=1; i<=k; i+=1) {
if(k % i== 0){
	if(j<=k) {
		System.out.println(k);
	}*/


