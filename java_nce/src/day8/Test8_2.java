package day8;

public class Test8_2 {

	public static void main(String[] args) {
		/*다음과 같이 출력되도록 작성하세요.a~z
		 * a
		 * ab
		 * abc*/
	
		
		for(int i=0;i<26;i+=1) {
			for (int k=0;k<=i;k+=1) {
				System.out.print((char)('a'+i));
			}
			System.out.println();
		}
		//@@@ 오 아래위 다르네??? 왜지
		
		for(char ch='a';ch<='z';ch+=1) {
			for (char sh='a';sh<=ch;sh+=1) {
				System.out.print(sh+" ");
			}
			System.out.println();
		}
		
		String str = "";
		for(char i='a';i<='z';i+=1) {
			str+=i;
			System.out.println(str);
		}

	}

}
