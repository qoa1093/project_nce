package day4;

public class For15 {

	public static void main(String[] args) {
		/*100이하의 모든 소수를 출력하는 코드를 작성하세요. @@@ 얘도 다시해보자
		 * */
		
		int i, num,cnt=0;
		for(num = 1; num <= 100; num += 1){			
			for(i = 1,cnt = 0; i <= num; i += 1) { //초기화하는부분에 넣어주면됨
				if(num % i == 0) {
					cnt+=1;
				}
			}
			
			if(cnt==2) {
				System.out.println(num);		//cnt갯수가 누적되기 때문에 더 안뜸 
												//따라서 다시 처음으로 돌아가 초기화해줘야함 cnt=0;
			}			
		}
		
	}
}
