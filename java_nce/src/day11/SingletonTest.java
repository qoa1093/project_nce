package day11;

public class SingletonTest {

	public static void main(String[] args) {
		/* 싱글톤 : 전체 프로그램에서 하나의 클래스로 단 하나의 객체만 있어야 하는 경우에 만든
		 * 		 단 하나의 객체 
		 * 1. 싱글톤을 만들려면, 생성자의 접근제한자를 private해서 외부에서 생성자를 호출할 수 없게 한다.
		 * 2. 클래스의 멤버변수로 해당 클래스의 클래스 변수를 만듦
		 * 3. 클래스 변수를 가져오는 메소드 선언 및 구현
		 * */
		//Singleton s = new Singleton(); //에러발생 : 생성자의 접근제한자가 private이어서 호출이 불가능
		Singleton s = Singleton.getSingleton();
		Singleton s1 = Singleton.getSingleton();
		if(s == s1) {
			System.out.println("같은 객체입니다. ");
		}
	}

}
class Singleton{
	//2.
	private static Singleton singleton = new Singleton();
	//1.
	private Singleton() {}
	//3.
	public static Singleton getSingleton() {
		return singleton;
	}
	
}