package day4;

public class For8 {

	public static void main(String[] args) {
		/*a부터 z까지 출력하는 코드를 작성하세요.*/
		//2가지 방법이 있음.
		
		char ch = 'a' + 0;
		System.out.println(ch);
		ch = 'a' + 1;
		System.out.println(ch);
		ch = 'a' + 2;
		System.out.println(ch);
		
		
		//내코드
		for(ch='a';ch<='z';ch+=1) {
			System.out.print((char)ch + " ");
		}
		
		
								
		System.out.println(); //한줄 띄우기
	
		/*방법1:
		 * 반복횟수 : i는 0부터 i는 26보다 작을 때까지(25보다 작거나 같다)
		 * 		   i는 1씩 증가
		 * 규칙성 :  (char)('a'+i)를 출력
		 * 반복문 종료 후 : 없음
		 * */
		int i;
		for(i=0; i<26; i+=1) {
			System.out.print((char)('a'+i)+" ");
		}
		
		System.out.println();
		
		/*방법2:
		 * 반복횟수 : sh는 'a'부터 sh는 'z'까지 sh는 1씩 증가
		 * 규칙성 : sh를 출력
		 * 반복문 종료 후 : 없음
		 * */
		char sh;
		for(sh = 'a' ; sh<='z'; sh+=1) {
			System.out.print(sh+" ");
		}
		
		
		
		
	}

}
