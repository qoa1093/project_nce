package day1;

public class Test1_2 {

	public static void main(String[] args) {
		// 정수 변수 num1에 1을 저장한 후 출력
		int num1 = 1;
		System.out.println(num1);
		//정수 변수 num2에 2를 저장한 후 출력
		int num2 = 2;
		System.out.println(num2);
		//문자변수 op에 +를 저장한 후 출력
		
		char op = '+';
		//String op = "+"; // char op = '+'; 문자말고 문자열로 해도 되긴 되는데 문제는 문자로 물어봄 
		System.out.println(op);
		
		//num1과 num2와 op를 조합하여 1+2가 출력되도록 작성
		System.out.println("" + num1 + op + num2); //문자열 + 정수는 문자열이 됨, 따라서 빈문자열로 시작
	}

}
