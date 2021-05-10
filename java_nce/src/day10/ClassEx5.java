package day10;

import java.util.Scanner;

public class ClassEx5 {

	public static void main(String[] args) {
		/*circle 클래스를 이용하여 원 객체를 생성한 후 테스트하는 예제*/
		Circle cr = new Circle();
		cr.print();
		//중심점을 5,5로 이동
		cr.move(5, 5);
		//반지름 길이 변경 5로
		cr.setR(5);
		cr.print();
		// 스캐너라는 클래스를 이용하여 스캔이라는 객체를 선언하고 
		//new를 이용하여 객체를 만들고, 만들어진 객체의 멤버변수를 Scanner(System.in) 생성자를 이용하여 초기화 ; 객체를 생성
		Scanner scan = new Scanner(System.in); //정보가 주어지면 정보(system.in)를 가지고 객체(scan)를 만드는 생성자  new 다음부분
		//생성자가 하는역할 : 멤버변수 초기화(o), 객체생성(x) -> new가 객체를 만들고 생성자가 초기화함
	}

}
