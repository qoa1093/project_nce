package day5;

public class while02 {

	public static void main(String[] args) {
		// while문과 continue를 이용한 짝수출력예제(테스트4_2참조)
		
		int i=1, num= 10;
		while(i<=num) {
			if(i % 2 !=0){
				i += 1;
				continue;
			}
			System.out.println(i + " ");
			i += 1;
		}
		System.out.println();
		
		i=0;
		while(++i<=num) {
			if(i%2!=0) {
				continue;
			}
			System.out.print(i + " ");
		}
		
	}

}
