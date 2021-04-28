package day3;

public class Test3_6 {

	public static void main(String[] args) {
		/*1부터 10까지의 짝수들의 합을 구하는 예제
		 * */ 
		
		int i, sum = 0, j = 1;
		for(i=2; i<11; i+=2){
			sum += i;
			j = i-1;
			System.out.println("1부터 10까지의 홀수는 "+j);
		}
		System.out.println("1부터 10까지의 짝수들의 합은 "+sum);
	}

}
