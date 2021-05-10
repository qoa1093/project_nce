package day10;

public class ClassEx6 {

	public static void main(String[] args) {
		Rect r1 = new Rect();
		r1.print();
		Rect r2 = new Rect(0, 10, 10, 0);
		r2.print();
		Point lu1 = new Point(0,20);
		Point rd1 = new Point(20,0);
		Rect r3 = new Rect(lu1, rd1);
		r3.print();
		lu1.setX(-10);			//좌표 점 하나 바꿨는데 사각형 r3의 좌표 점 위치가가 덩달아 바뀌는 문제가 생김 나머지는 내일시간에
		r3.print();
	}

}
