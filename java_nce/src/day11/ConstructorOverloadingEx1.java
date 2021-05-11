package day11;

public class ConstructorOverloadingEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		A a2 = new A(1,2);
		//A a3 = new A(1.0,2);	//실수가 정수로 자동형 변환이 안되기 때문에 에러
		A a4 = new A('a',3);	//문자가 정수로 자동형 변환이 되기 때문에 에러 x
	}

}
class A{
	private int num1;
	private int num2;
	public void A() {}		//생성자와 이름이 같은 메소드 : 가능은 하지만 조심
	public A() {}	//동일 생성자 두개잇으면 메인에서 뭐로 데려올지 몰라서 에러남
	
	//복사 생성자 : 생성자의 매개변수로 같은 클래스의 객체가 오는 경우
	public A(A a){
		num1 = a.num1;	//멤버변수의 값을 복사한다고 해서 복사생성자 객체이름은 다를수 있지만 클래스는 고정/
		num2 = a.num2;
	}
	
	public A(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	//public A(double num3, double num4) {} 
}