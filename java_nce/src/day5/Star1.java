package day5;

public class Star1 {

	public static void main(String[] args) {
		/* ***** k = 1 *=5
		 * ***** k = 2 *=5
		 * ***** k = 3 *=5
		 * ***** k = 4 *=5
		 * ***** k = 5 *=5 -> *의 갯수 = k
		 * */
		int i, k;
		for(k=1;k<=5;k+=1) {
			for(i=1;i<=4;i+=1) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------");
		
		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		
		for(k=1;k<=5;k+=1) {
			for(i=1;i<=k;i+=1) {				//@@@별의 개수는 k값 증가와 동일하므로 ;다시 풀어볼것
				System.out.print("*");			
			}
			System.out.println();
		}
		
		System.out.println("------");
		
		/* ++++**** k=1 공백=4 *=4
		 * ++++**** k=2
		 * ++++**** k=3
		 * ++++**** k=4
		 * ++++**** k=5
		 * */
		
		for(k=1;k<=5;k+=1) {
			//System.out.print("    ");
			for(i=1;i<=4;i+=1) {
				System.out.print(" ");					//for문 이중으로 안길수도 있네
			}
			for(i=1;i<=4;i+=1) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------");
		
		/* ++++*	k=1 공=4 	*=1
		 * +++**	k=2 공=3 	*=2
		 * ++***	k=3 공=2 	*=3
		 * +****	k=4 공=1 	*=4
		 * *****	k=5 공=0 	*=5
		 * 				공=5-k
		 * 						*=k
		 * */
		for(k=1;k<=5;k+=1) {
			for(i=4;i>=k;i-=1) {					//@@@이중으로 안긴 for문 + (별갯수증감=k(줄)갯수의 증감)
				System.out.print("+");				//공백("+")출력 (선생님코드 : for(i=1;i<=5-k;i+=1))
				
			}
			for(i=1;i<=k;i+=1) {					//별 출력 변수 i는 중요한데이터가 아니므로 초기화해서 재사용가능(중요한 변수라면 초기화 x)
				System.out.print("*");				//k를 이용한 작업이 다 끝나지 않았는데 다시 k를 사용하면 무한루프위험성존재(x)
			}										//i는 위에서 이미 다 사용한 변수이기 때문에 재사용가능
			System.out.println();					//줄바꿈 출력
		}
	}

}
