package day11;

import day1.Test1_1;

public class ThisTest {

	public static void main(String[] args) {
		// 
		TestA t = new TestA(5);
		t.print();

	}
}
class TestA{
	private int num;
	public TestA(int num) {
		//멤버 변수 num에 매개변수 num의 값을 저장
		//메소드에서 우선순위는 멤버변수보다 매개변수가 높다
		//num =num;
		this.num = num; //매개변수와 멤버변수 이름이 같을때 사용
	}
	public void print() {
		System.out.println("num: "+num);
	}
}
