package day2;
import java.util.Scanner;

public class Test2_6 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적을 출력하는 코드를 작성하세요.
		 * A :  90이상 100이하 
		 * B : 80이상 90미만
		 * C : 70이상 80미만
		 * D :60이상 70미만
		 * F :0이상 60미만
		 * 잘못된 성적 : 0미만, 100초과*/
		System.out.println("성적을 입력하시오: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if(num>=90 && 100>= num) {
			System.out.println("A");
		}else if(num>=80 && 90>num) {
			System.out.println("B");
		}else if(num>=70 && 80>num) {
			System.out.println("C");
		}else if(num>=60 && 70>num) {
			System.out.println("D");
		}else if(num>=0 && 60>num) {
			System.out.println("F");
		}else {
			System.out.println("잘못된성적입니다.");
		}

	}

}
