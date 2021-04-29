package day4;

public class Continue {

	public static void main(String[] args) {
		//continue 정리
		int i;
		for(i=1;i<=5;i+=1) {
			if(i == 2) {
				continue;
			}
			System.out.println(i);System.out.println("Hello");
		}

	}

}
