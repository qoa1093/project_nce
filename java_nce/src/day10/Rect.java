package day10;

public class Rect {
	//너비 : width 정수, 높이 : height 정수
	//왼쪽 위의 점 : leftUp , int left, up == private Point leftUp;
	//오른쪽 아래 점 : rightDown, int right, down == private Point rightDown;
	
	private Point rd;
	private Point lu;
	private int h, l;
	
	/* 기능 : 사각형의 정보를 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : print*/
	public void print() {
		System.out.print("rightDown: ");
		rd.print();
		System.out.print("leftUp: ");
		lu.print();
		System.out.println("너비 : "+ l +'\n'+"높이 : " + h);
	}
	
	/* rd(4,0) lu(0,5) => 높이 h = lu(y)-rd(y), 가로 l = rd(x)-lu(x)*/

	/*기본 생성자 : 왼쪽 위의 점을 나타내는 객체를 생성, 오른쪽 위의 점을 나타내는 객체 생성*/
	public Rect() {
		lu = new Point();
		rd = new Point();
	}
	
	/* 생성자 : 좌상점과 우하점이 주어지면 해당 점을 이용한 사각형이 되도록 초기화
	 * 		  좌상점, 우하점 초기화, 너비와 높이도 계산해서 초기화*/ //생성자 둘중 하나만 실행되기때문에 위에 생성자 코드가 있어도 새로 만들어줘야함
	public Rect(int left, int up, int right, int down) {
		lu = new Point(left,up);
		rd = new Point(right,down);
		l = right - left;
		h = up - down;
	}
		
	// # 내코드 : 참조변수는 주소를 같다고 저장하기 때문에 공유를 하게됨 따라서 lu1 lu가 내용이 바뀌면 같이 바뀜. 따라서 완성된 코드가 아님.
	  public Rect(Point lu1, Point rd1) {
		lu = lu1;
		rd = rd1;
		h = lu.getY() - rd.getY();
		l = rd.getX() - lu.getX();
	}
	
	/* 기능 : 주어진 좌표로 왼쪽 위의 점을 이동시키는 메소드
	 * 매개변수 : 주어진 좌표위의 x,y좌표 => int x, y
	 * 리턴타입 : 
	 * 메소드명 : move*/
	
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public Point getRd() {
		return rd;
	}

	public void setRd(Point rd) {
		this.rd = rd;
	}

	public Point getLu() {
		return lu;
	}

	public void setLu(Point lu) {
		this.lu = lu;
	}

}
