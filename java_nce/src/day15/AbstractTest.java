package day15;

public class AbstractTest {

	public static void main(String[] args) {
		// 클래스 A의 객체 a를 생성
		A a = new A();
		//추상 클래스 B의 객체 b를 생성
		//B b = new B();//오류발생
		//추상 클래스 B를 상속받은 클래스 C의 객체 c를 생성
		C c = new C();//에러안남
		//클래스 C를 이용하여 객체를 생성한 후 추상 클래스 B의 객체에 저장 (자식은 부모의 메소드,변수를 상속받기 때문에 적어도 부모보다 크다)
		B b1 = new C(); //클래스 타입변환(자동)
	}

}


class A{}


abstract class B{
	abstract void print();
}


class C extends B{
	@Override
	void print() {		
	}
}


class D{}
