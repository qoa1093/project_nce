package day2;

public class Logical_Operator {

	public static void main(String[] args) {
		// 논리 연산자 예제05
		//!연산자
		System.out.println("4는 짝수인가?" + (4 % 2 == 0));
		System.out.println("4는 홀수가 아닌가?" + !(4 % 2 == 1)); //뒤집기 !
		
		//&&연산자
		/*변수 num가 2의 배수이고 3의 배수이면 6의 배수이다.
		 * 6은 2와 3의 공배수이므로 && 연산자 사용해서 둘다 확인해야함*/
		int num = 6;
		System.out.println(num + "은(는) 6의 배수인가?" + (num % 2 == 0 && num % 3 == 0));
		
		//||연산자
		/*청소년은 14세부터 19세까지이다
		 * 나이가 age인 학생이 청소년인지 아닌지 확인하는 예제*/
		int age = 20;
		System.out.println(age + "살은 청소년이 아닌가?" + (age < 14 || age > 19)); //@@@괄호는 더 넣을 필요 없는데 이상,이하를 표현할때는 반드리 부등호가 앞에 오도록 써야함
		
		//XOR 연산자
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		//결합연산자(+= 등등)
		

	}

}
