package day13;

public class VariableTest {

	public static void main(String[] args) {
		//클래스로 만드는 변수가 객체 일반변수는 값 참조변수는 주소
		int num5 = 0;		// 일반변수
		String str3 = "Hello";	//참조변수 
		int [] arr = new int [5];	//참조변수 배열(아직 초기화는 되지 않은)
		//Board [] board = new Board[5];//클래스로 만든 배열은 값 하나하나가 모두 참조변수,보드배열은 결국 두번 주소값 참조
	}

}
class A{
	int num1;				//클래스 A의 멤버변수
	static int num2;		//정적변수(클래스변수)
	String str1;			//참조변수이자 멤버변수
	static String str2;		//정적변수(참조변수)
	public A(int num3, int num4) {	//매개변수이자 A의 생성자에서 클래스 A의 멤버변수 NUM1,NUM2를 매개변수값으로 초기화  
		num1 = num3;
		num2 = num4;
	}
}
