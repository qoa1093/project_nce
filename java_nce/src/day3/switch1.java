package day3;

public class switch1 {

	public static void main(String[] args) {
		// switch연습~
		/*switch문을 이용한 홀짝 판별 예제*/
		int num = 5;
		
		switch(num % 2) {                   // t/f 불가능해서 논리형값이 오는 식은 에러남
		case 0:
			System.out.println("짝수");  //@@@오늘 코드 너무 예쁘다 깔끔하고
			break;
		default:
			System.out.println("홀수");
		}
	}
}
	