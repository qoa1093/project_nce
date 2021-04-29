package day4;

import java.util.Scanner;

public class For11 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 8의 배수 : 8, 16, 24, 32 ...
		 * 12의 배수 : 12, 24, 36, 48 ...
		 * 8과 12의 공배수 : 24, 48, 72 ...
		 * 8과 12의 최소공배수 : 24
		 * 최소공배수 으악
		 * 반복횟수 : i는 1부터 두수의 곱보다 작거나 같음 = 두수의 곱까지 1씩 증가 8에서 12까지 1번?
		 * 규칙성 : i가 num1의 배수이고 i가 num2의 배수이면 i를 출력 후 반복문종료 ; 8이면서 12인거
		 * 			=> i를 num1으로 나누었을때 나머지가 0과 같고
		 * 			   i를 num2로 나누었을때 나머지가 0과 같다면
		 * 			   i를 출력 후 반복문 종료
		 * 반복문 종료 후 : 없음
		 * */ 
		Scanner scan = new Scanner(System.in);
		System.out.print("최소공배수를 구할 두 정수를 입력하시오: ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		scan.close();
		/*#int i;
		for(i=1;i<=num1*num2;i+=1) {
			if(i%num1==0 && i%num2==0) {
				System.out.println(i);
				break;
			}
		}
		//내코드
		int m, j=12, k=8;
		for(m=1;m<=j*k;m+=1) {
			if(m%k==0 && m%j==0) {
				System.out.println(m);
				break;
			}
		}
		#*/
		/* 반복횟수 : i는 num1부터 무한대로 i는 num1씩 증가
		 * 규칙성 : i가 num2의 배수이면 i를 출력후 반복문 종료
		 * */
		int q;
		for(q=num1; ;q += num1) {		//@@@아그치 곱하기할 필요없네 곱하기는 그만큼더하기니까
			if(q%num2==0) {			//이렇게하면 1부터 num2까지(num2>=num1)더 많이 계산할 필요없이 
			System.out.println(q);	//num1->num2범위 내에서 해결되므로 효율적임
			break;
			}
		
		}
	}

}
