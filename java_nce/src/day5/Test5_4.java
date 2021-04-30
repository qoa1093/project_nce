package day5;

import java.util.Scanner;

public class Test5_4 {

	public static void main(String[] args) {
		/*학생 3명의 성적을 입력받은 후 총점과 평균을 출력하는 코드를 작성하세요.*/
		
		
		
		int i, j;
		int arr[] = new int[3];
		
		System.out.print("3명의 성적을 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		
		for(i=0;i<arr.length;i+=1) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		for(i=0,j=0;i<arr.length;i+=1) {
			j += arr[i];
		}
		
		System.out.print("총점: "+j+" ");
		System.out.println("평균: "+ (double)(j/arr.length));

	}

}
