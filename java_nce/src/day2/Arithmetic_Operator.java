package day2;

public class Arithmetic_Operator {

	public static void main(String[] args) {
		// 산술연산자 예제02
		
		System.out.println(" 1   / 2   = " + 1   / 2 ); // 정수 나누기 정수는 정수임 나머지버려짐. 9/5는 1임 하지만 9.0 /5는 1.8이되는 기적
		System.out.println(" 1.0 / 2   = " + 1.0 / 2);
		System.out.println(" 1   / 2.0 = " + 1   / 2.0);
		System.out.println(" 1.0 / 2.0 = " + 1.0 / 2.0);
		int num1 = 1, num2 = 2; //강제타입변환 괄호치고 출력전에 넣기 정수 ->실수 타입변환(일시적)
		System.out.println((double)num1 / num2);
		System.out.println("7 % 4 = "+ 7 % 4);
		char ch = 65; // a 더하기 1을 문자(char)로 바꾸면 b가 되네 //@@@난 char을 아예 이해를 못하고있네
		ch = (char)(ch + 1); //char + int는 int가 되어서 char로 강제 타입변환해줘야함 
		System.out.println(ch);
		
		
		
	}

}
