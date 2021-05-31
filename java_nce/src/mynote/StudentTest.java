package mynote;

public class StudentTest {

	public static void main(String[] args) {
		/* 학생 정보를 관리하는 student 클래스를 생성하세요. 1학년 1반 1번 홍길동 학생의 객체를 생성한 후ㅡ 학생 정보를 출력하는 코드를 main메소드에 작성하여 테스트하세요.
		 * 학생 클래스
		 * 정보 : 학년, 반, 번호, 이름
		 * 기능 : 학생 정보 출력 기능*/ 
		Student st1 = new Student();
		st1.print(1, 1, 1, "홍길동");

	}

}
class  Student{
	int gd;
	int clNum;
	int stNum;
	String name;
	
	public void print(int gd, int clNum, int stNum, String name) {
		System.out.println(" 학년 : "+ gd +"\n 반 : " + clNum + "\n 번호 : " + stNum + "\n 이름 : "+ name);
	}
	
	public Student() {}
	
	public Student(int gd, int clNum, int stNum, String name) {
		this.gd = gd;
		this.clNum = clNum;
		this.stNum = stNum;
		this.name = name;
	}
	
	public int getGd() {
		return gd;
	}
	public void setGd(int gd) {
		this.gd = gd;
	}
	public int getClNum() {
		return clNum;
	}
	public void setClNum(int clNum) {
		this.clNum = clNum;
	}
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
