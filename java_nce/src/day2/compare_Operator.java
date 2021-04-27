package day2;

public class compare_Operator {

	public static void main(String[] args) {
		// 비교연산자 예제04
		
		System.out.println("1>2: "+(1>2));
		System.out.println("1>=2: "+(1>=2));
		System.out.println("1<2: "+(1<2));
		System.out.println("1<=2: "+(1<=2));
		System.out.println("1==2: "+(1==2));
		System.out.println("1!=2: "+(1!=2));

		//4는 짝수인가?를 확인하기 위한 코드를 작성해보세요.
		//짝수 : 2로 나누었을때 나머지가 0과 같으면 짝수
		
		System.out.println("3는 짝수인가? "+( 0 == (3 % 2))); // (4 % 2 == 0) //@@@얘도 더 줄일수 있ㅇ
		
		//double과 float의 소수점 정확도(소수점 표현방식)가 다르기 때문에 정확하게 0.1이 아님. 따라서 0.1과 0.1f는 다름(120P)
		System.out.println(0.1 == 0.1f); // false
		
		System.out.println('A' == 65);
		
		
	}

}
