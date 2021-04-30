package day5;

public class AdvanceFor {

	public static void main(String[] args) {
		/*향상된 for문 예제
		 * - 배열이나 컬렉션프레임워크에서 사용가능한 for문
		 * - 전체 탐색할 때 사용(건너뛰기 안되고 처음부터 끝까지 확인할때 사용)
		 * - 값을 가져올 때 사용(평균구하기 등 ..)
		 * - 값을 변경할 때 사용하지 않음
		 * for(타입 변수 : 배열명){ (배열이랑 같은 타입이어야 함 변수는)
		 * 		실행문;
		 * }
		 * */
		
		int [] arr = {1,2,3,4,5};
		for(int i = 0; i<arr.length;i+=1) {
			int tmp = arr[i];
			System.out.print(tmp+" ");		//위아래 동일한 코드 : 1번은 arr[]의 값을 알수 있어서 arr[i]=arr[i]*2가능
		}
		for(int tmp:arr) {					//arr[]의 값을 가져와서 tmp에 저장함 : 2번은 arr[]의 값 알수없음.따라서 arr값 변경 불가
			System.out.print(tmp+" ");
		}
		
		
		
		

	}

}
