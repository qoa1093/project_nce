package day15;

public class ClassCastExceptionTest {

	public static void main(String[] args) {
		Figure f1 = new Rect();
		Figure f2 = new Figure();
		
		Rect r1 = (Rect)f1;	//rect로 만들어서 예외발생 xx
		//클래스 타입 변환이 불가능하여 예외 발생
		//Rect r2 = (Rect)f2;	//부모로 만든건 강제 형변환 안됨
		//조건문과 instanceof를 이용한 예외 방지
		if(f2 instanceof Rect) {
			Rect r2 = (Rect)f2;
			System.out.println("타입변환성공");
		}
	}

}
class Figure{}
class Rect extends Figure{}
