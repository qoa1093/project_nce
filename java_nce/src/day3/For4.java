package day3;

public class For4 {

	public static void main(String[] args) {
		/*1부터 10까지의 짝수들만 출력하는 코드를 작성하세요.*/
		int i;
		for(i=2;i<11;i+=2){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int j;						//방법1 : 1부터 10까지 다 확인한 후 짝수들만 출력
		for(j=1; j<=10; j++){		//j가 짝수이면 j를 출력
			if(j % 2 == 0) {
				System.out.print(j+" ");
			}
		}
		System.out.println();
		
		int k;						//방법2 : 2부터 10까지 짝수들만 확인하고 출력
		for(k=2; k<=10; k=k+2){
			System.out.print(k+" ");
		}
		System.out.println();
		
		int l;						//방법3 : 1부터 5에다가 곱하기 2를 출력 
		for(l=1; l<=5; l++){
			System.out.print(l*2+" ");
		}
		
	}

}
