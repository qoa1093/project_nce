package day10;

public class ClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.num = 10;
		
		B b = new B();
		b.num = 10;
		
		C c = new C();
		c.num = 10;
		
		D d = new D();
		//d.num = 10; // 에러 발생 :  num의 접근제한자가 private이어서
		d.setNum(10);
		System.out.println(d.getNum());
	}

}
