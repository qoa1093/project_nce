package day10_1;

import day10.A;
import day10.B;
import day10.C;
import day10.D;
import day10.ClassEx; // day 10 패키지에 있는 클래스 얘를 가져오려고 한다.

public class ClassEx2 {

	public static void main(String[] args) {
		A a = new A();
		a.num = 10;
		
		B b = new B();		//다른 패키지에 있어서 에러가 발생
		//b.num = 10;
		
		C c = new C();		//다른 패키지
		//c.num = 10;
		
		D d = new D();
		//d.num = 10; // 에러 발생 :  num의 접근제한자가 private이어서

	}

}
