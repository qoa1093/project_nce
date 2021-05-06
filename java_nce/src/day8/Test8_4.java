package day8;

public class Test8_4 {

	public static void main(String[] args) {
		/*1부터 10까지 한줄로 출력되는 코드를 작성하세요.
		 * 출력이 다음과 같이 되도록 코드를 작성하세요.
		 * 1 2 3 4
		 * 5 6 7 8
		 * 9 10*/
		
		for(int i=1;i<=10;i+=1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 1, j = 0; i <=10; i+=1) {
			System.out.print(i + " ");
			j+=1;
			if(j%4==0) {
				System.out.println();
			}
		}
		System.out.println("\n---------------");
		
		for(int i = 1, j = 0; i <=10; i+=1) {
			System.out.print(i);
			j+=1;
			if(j%4==0) {
				System.out.println();
			}else if(j%4!=0 && j != 10) {
				System.out.print(",");
			}
		}
		System.out.println("\n---------------");
		
		for(int i = 1, j = 0; i <=12; i+=1) {
			System.out.print(i);
			if(i%4==0) {
				System.out.println();
			}else  {
				System.out.print(",");
			}
			//String str = i%4 == 0? "\n" : " ";
			//System.out.print(str);
		}
		/*다음과 같이 출력되도록 코드를 작성하세요.
		 * 2 1 4 3 -1, +3, -1 +3 			// -1 +1 -1 +1(i)
		 * 6 5 8 7 -1  +3 -1 +3 
		 * 10 9 12 11 */
		
		for(int i=1;i<=12;i+=1) {
			if(i%2!=0) {
				System.out.print(i+1);
			}else{
			System.out.print(i-1);
			}
			String str = i % 4 ==0? "\n" : " ";
			System.out.print(str);
		}
		
		

	}

}
