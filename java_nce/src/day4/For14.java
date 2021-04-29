package day4;

public class For14 {

	public static void main(String[] args) {
		/*정수 num이 소수인지 아닌지 판별하는 코드를 작성하세요. @@@필기 다시정리
		 * 소수 : 약수가 2개인 수
		 * 소수 : 2 3 4 7 11 13 17
		 * 4: 1 2 4
		 * 반복횟수 :
		 * 규칙성 :
		 * 반복문 종료 후 :
		 * */
		int num=7/*입력값*/,cnt=0/*약수의 갯수*/, i;
	
			for(i=1;i<=num;i+=1) {				//약수의 갯수출력
				if(num%i==0) {
					cnt+=1;
				}
				
			}
			if(cnt==2) {
				System.out.println("소수입니다.");
			}else {
				System.out.println("n");
			}
			
			
		
			//약수가 2개이면 브레이크?
			
	}

}
