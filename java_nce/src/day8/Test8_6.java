package day8;

public class Test8_6 {

	public static void main(String[] args) {
		/*5개짜리 배열에 같은 숫자가 2개 있는지 없는지 판별하는 코드 작성
		 * 단, 숫자는 정렬되어 있다고 가정
		 * 예시 : 1 1 2 3 4
		 * 있음
		 * 예시 : 1 2 3 4 5
		 * 없음
		 *#수정
		 * 예시 : 마지막 두개가 연속인 경우 1 1 1 2 2 
		 * 없음
		 * 
		 * 반복문 종료 후 cnt가 2와 같으면 res를 true로 수정
		 * */ 
		
		//int arr[] = new int[5];
		int num[] = {1,1,1,2,2};
		int cnt=1;
		boolean res = false;
		for(int i=0;i<num.length-1;i+=1) {
				if(num[i]==num[i+1]) {
					cnt+=1;
				}else{
					if(cnt==2) {
						res = true;
									//@@@밖에 꺼내면?
					}
					cnt=1; //카운트 값이 3이 되면  cnt 1로 초기화해줘서 다시 새숫자 중복 세기
				
			}
		}
		if(cnt ==2) {
			res = true;
		}
		if(res) {
			System.out.println("있음");
		}else {
			System.out.println("없음");
		}

	}

}
