package day13;

public class PolymorphismTest {

	public static void main(String[] args) {
		// 사고 후 앞 왼쪽 바퀴를 한국 타이어로 교체

	}
	//매개변수의 다형성을 확인하는 예제
	//instanceof를 이용하면 매개변수의 다형성을 처리하기가 쉬워진다.
	/* 기능 : 타이어에 이상이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 타이어 => Tire t
	 * 리턴타입 : 이상여부 => 참 거짓 =>boolean
	 * 메소드명 : confirm*/
	//타이어 t가 한국타이어면 예외가 발생하지 않고 금호타이어면 예외가 발생함
	public static boolean confirm(Tire t) {
		//HankookTire ht = (HankookTire)t;
		if(t instanceof HankookTire) {
			HankookTire ht =(HankookTire)t;
			System.out.println("한국타이어 검사 끝!");
			//한국 타이어 검사하는 코드 작성했다고 가정
		}else if(t instanceof kumhoTire) {
			kumhoTire kt = (kumhoTire)t;
			//금호 타이어 검사하는 코드 작성했다고 가정
			System.out.println("금호 타이어 검사 끝!");
		}
		return false;
	} 

}
class Car2{
	public Tire frontLeftTire;
	public Tire frontRightTire;
	public Tire backLeftTire;
	public Tire backRightTire;
}
class Tire{}

class kumhoTire extends Tire{}
class HankookTire extends Tire{}
