package day3;

public class Test3_1 {

	public static void main(String[] args) {
		
		// "/"와 "%"는 0으로 나누지 말자~ 예외 발생 안할수 있지만 그래도!
		int num1 =1, num2 = 0;
		int res = num1 / num2; //예외발생
		//System.out.println(res);
		System.out.println(1.0/0); // 에러는 아니지만 무한으로 뜸 졸랴
		

	}

}
