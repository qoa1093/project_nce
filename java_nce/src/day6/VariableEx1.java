package day6;

public class VariableEx1 {
	static int num = 10;//VariableEx1 클래스의 멤버변수 num
	public static void main(String[] args) {
		/* 지역변수 : 우리가 지금까지 사용한 일반 변수, 특정 지역에서만 사용 가능한 변수
		 * 멤버변수 : 클래스안에 있는 변수로, 해당 클래스의 모든 곳에서 사용 가능
		 * */ 
		// 지역변수 = 선언한 위치부터 해당 {} 안 끝까지 사용가능 (그 위, 그 바깥 안됨xxxxx)
		// i는 11번째 줄부터 21번째 줄까지 사용가능, i는 main 메소드 안에서 선언했기 때문에 선언위치부터 main메소드 끝까지 사용가능
		int i; 
		for(i=1;i<=5;i+=1){
			System.out.print("*");
		}
		System.out.println(i);
		//k는 17번째줄부터 18번째줄까지 사용가능
		for(int k=1;k<=5;k+=1){	//k는 17번째줄부터 18번째 줄까지 사용가능
			System.out.print("*");
		}
		System.out.println(); // k넣으면 20번째 줄에서는 없는 변수기 때문에 에러가 남
		System.out.println(num);//멤버변수여서 따로 사용없이 클래스 내에서 다~~~ 가능!
	}
	public static void test() {
		//i 쓰면 없는 변수기 때문에 에러남(test메소드에서는 i라는 변수를 선언하지 않았기 때문에)
		System.out.println(num);
	}
}
