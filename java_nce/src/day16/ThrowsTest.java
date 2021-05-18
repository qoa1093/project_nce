package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
			test();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void test() throws Exception, ArithmeticException{
		throw new Exception("test 메소드에서 예외 발생");
	}
	//실행예외인 경우 throws부분 생략가능, ,를 사용하여 여러 예외클래스 적을 수 있음
	/*public static void test(){
		throw new RuntimeException("test 메소드에서 예외 발생");
	}*/

}
