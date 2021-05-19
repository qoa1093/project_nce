package day10;

import day10.Point; //같은 패키지에 한해서는 생략가능

public class ClassEx3 {

	public static void main(String[] args) {
		//pt라는 객체를 선언 후 생성 (메서드도 코드 할당되어서 어딘가에 주소가 있다..)
		//객체 pt는 참조변수
		//일반변수 : 타입이 기본타입으로 된 변수
		//참조변수 : 타입이 기본타입이 아닌 변수
		Point pt1 = null;
		Point pt2 = new Point();
		//에러 발생 : 객체가 생성되지 않은 상태에서 메소드를 호출했기 때문에
		//pt1.print();
		pt2.print();
		pt2.move(4, 3);
		pt2.print();
		Point pt3 = new Point(1,2);
		pt3.print();
	}

}
