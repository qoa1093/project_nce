package day8;

public class Test8_7 {

	public static void main(String[] args) {
		/*5개짜리 배열에 같은 숫자가 2개가 몇개 있는지 판별하는 코드 작성
		 * 단, 숫자는 정렬되어 있다고 가정
		 * 예시 : 1 1 2 3 4
		 * 1
		 * 예시 : 1 2 3 4 5
		 * 0
		 * 예시 : 1 1 2 2 4
		 * 2
		 * */ 
		
		//int arr[] = new int[5];
		int num[] = {1,2,3,4,5};
		int cnt=1;
		int res = 0;
		for(int i=0;i<num.length-1;i+=1) {
				if(num[i]==num[i+1]) {
					cnt+=1;
				}else{
					if(cnt==2) {
						res += 1;				
					}
					cnt=1; 	
			}
		}
		if(cnt == 2) {
			res += 1;
		}
		if(res>=1) {
			System.out.println(res + "있음");
		}else {
			System.out.println(res + "없음");
		}

	}

}
