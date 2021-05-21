package day18;

import java.util.ArrayList;

public class ListTest3 {

	public static void main(String[] args) {
		/*indexOf()
		 * 리스트에서 indexOf와 contains 메소드를 잘 활용하려면 
		 * 해당 클래스에서 equals를 오버라이딩해야한다. */
		ArrayList<Student> list = new ArrayList<Student>();
		Student std1 = new Student(1,1,1,"홍길동");
		Student std2 = new Student(1,1,1,"홍길동");
		list.add(std1);
		System.out.println("리스트에 학생정보가 있습니까? "+ list.indexOf(std2));	//주소 비교하는거라 해당 클래스에 이퀄스 오버라이딩 필수 안그러면 걍 주소 비교해서 틀리다 함...
		System.out.println("리스트에 학생정보가 있습니까? "+ list.contains(std2));

	}

}
class Student{
	int grade;
	int classNum;
	int num;
	String name;
	public Student(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
}//tostr 
