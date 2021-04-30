package day5;

public class Test5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ab";							//"ab":리터럴, 리터럴값은 따로 모아서 씀.그 메모리에서 참조함.
		String str2 = "ab";							//같은 메모리영역에 이미 "ab"값이 존재하므로 동일주소에서 참조 ==두값이 같음
		if(str1==str2) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
		
		String str3 = new String("ab");				//new에 의해 새로운 공간(주소값) 생성, 새로운 공간에서 메모리영역"ab"를 참조한 영역 주소값을 참조함.
		String str4 = new String("ab");				//new에 의해 역시 새로운 공간 생성 !=두값이 서로 다름
		if(str3==str4) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}

	}

}
