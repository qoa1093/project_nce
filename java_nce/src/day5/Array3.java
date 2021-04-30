package day5;

public class Array3 {

	public static void main(String[] args) {
		/*정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력
		 * 
		 * 반복횟수 : i는 1부터 num보다 작거나 같을 때까지 1씩 증가
		 * 규칙성 : num을 i로 나누었을 대 나머지가 1과 같으면
		 * 		  배열 cnt번지에 i를 저장 후
		 * 		  cnt를 1 증가 후
		 * 		  cnt가 10과 같으면 반복문 종료
		 * 반복문 종료 후 : 배열에 있는 값을 0번지부터 cnt개 출력*/
		
		int i, r=0, num = 10; int arr[]=new int[10];
		//약수 : num%i==0일때의 i
		
		for(i=1;i<=num;i+=1) {
			if(num%i==0) {						// 8의약수 1248 
				arr[r] = i;						// arr에 저장하기
				r+=1;
				if(r==0) {
					break;
				}
			}
		}
		System.out.println(r);					//@@@아 여기서 막혓네
		/*for(int tmp:arr) {
			System.out.print(tmp+" ");
		}*/
		
			
		/* 강사님 코드
		 * int num = 12, i;
		 * int []arr = new int[10];
		 * int cnt = 0;
		 * for(i=1;i<=num;i+=1){
		 *  if(num%1==0){
		 *  	arr[cnt] = i;
		 *  	cnt +=1;
		 *  	if(cnt==10){
		 *  	break;
		 *  	}
		 *  }
		 * }
		 * for(i=0;i<cnt;i+=1){
		 * 	System.out.print(arr[i]+" ");
		 * }
		 * 배열에 있는 값 0번지부터 cnt개 출력;*/  //@@@향상된 for문은 이전의 값들이 나오기 때문에 r 0000이렇게 나옴
		
		

	}

}
