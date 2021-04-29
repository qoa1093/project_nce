package day4;

public class For9 {

	public static void main(String[] args) {
		/*무한루프 : 반복문이 끝나지 않는 경우를 무한루프라 한다.
		 * */
		for(;;) {  //조건식이 없거나, 조건식이 증감식과 함께하지 않으면 무한루프됨/조건식이 처음부터 거짓이면 아예 실행안됨.배고프당
			System.out.println("Hello world!"); //조건식이 무한히 참이기 때문에 계~속 출력
		}
		//System.out.println("Hi!"); //for문이 무한루프생성중이기 때문에 끝이 안나서 에러남...도달할수 없는 코드래

	}

}
