package day15;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class A1{
	void print() {
		System.out.println("Hello");
	}
}
class A2{
	void print() {
		System.out.println("Hi");
	}
}
//상속은 여러개 상속 불가능
/*class AC extends A1, A2{
	void test() {
		print();	// A1, A2 중 print()메소드를 호출했을때 누구의 메소드인지 구별할 수 없음.
	}				// 둘 중 어디서 불러야할지 몰라서 충돌이 남. 따라서 클래스에서 상속은 부모가 둘일 수 없음 
}*/

interface B1{
	void print();
}
interface B2{
	void print();
}
//구현은 여러개를 이어받기 가능 왜? : 구현 클래스에서 오버라이딩을 다시 하기 때문에 (구현을 다시하면 되기 때문에)
class BC implements B1, B2{
	@Override
	public void print() {
		System.out.println("안녕");
		
	}
	
}
//C1 클래스는 A1클래스를 상속받고, B1, B2인터페이스를 구현한 클래스이다 //@@@자동으로 해결이 안되서 위에서 붙임
class C1 extends A1 implements B1, B2{
	@Override
	public void print() {
		System.out.println("안녕");
		
	}
}
