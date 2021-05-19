package day10;

public class ClassEx {

	public static void main(String[] args) {
		A a = new A();
		a.num = 10; // public이기 때문에 에러가 발생하지 않음
		
		B b = new B(); // protected : 클래스 b와 ClassEx는 같은 패키지에 있으므로 에러 x
		b.num = 10;
		
		C c = new C(); // default : 같은 패키지에 있기 때문에 에러 x
		c.num = 10;
		
		D d = new D();
		//d.num = 10; // 에러 발생 :  num의 접근제한자가 private이어서
		d.setNum(10);
		System.out.println(d.getNum());
	}

}
