package day6;

public class ClassEx1 {

	public static void main(String[] args) {
		// 
		int x=1; 	//일반변수
		Point1 point = new Point1();
		System.out.println("main의 x: "+ x);
		System.out.println("Point의 x: "+ point.x);
		point.x = 3;
		System.out.println("Point의 x: "+ point.x);
		Point1 point2 = new Point1(1,2);					//@@@여기랑
		System.out.println("point2의 x: "+point2.x);
	}

}
//2차원 좌표 평면의 점을 나타내는 클래스 : Point1
//x좌표, y좌표 => 정수
//
class Point1{
	int x;		//멤버변수
	int y;
	//클래스에 생성자가 없으면 기본생성자가 자동으로 만들어져서 객체 실행할때 실행됨
	 public Point1() {}					/*기본생성자:*/
	public Point1(int x1, int y1) {		/*생성자*/			//@@@여기부분 꺼내와서 실행 , 정수1개는 없어서 실행 x
		x = x1; 						//이름이 같은 경우 this.x = x;로 씀( x=x는 그냥 자기가 자기값바꾸는거라 의미없음)
		y = y1;
	}
}