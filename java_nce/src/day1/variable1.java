package day1;

public class variable1 {

	public static void main(String[] args) {
		// 정수형 변수 선언
		//변수타입 변수명
		byte num1 = 1;
		short num2 = 32767;
		int num3 = 2147483647;
		long num4 = 2147483648L; //기본숫자는 int형. int 범위 밖 숫자표현시 long타입 뒤에는 l 소문자 대문자 아무거나 쓰세요
		char ch1 = '한';
		int num5 = 0b111; //정수앞에 0b를 붙이면 2진수, 2진수 111 => 10진수 7
		int num6 = 0111; //0 8진수, 8진수 111=>10진수 73
		int num7 = 0x111; //0x 16wlstn 16wlstn 111=>10wlstn 273
		int num8 = 111; //10진수
		System.out.println(num5);//7
		System.out.println(num6);//73
		System.out.println(num7);//273
		System.out.println(num8);//111
		float dnum1 = 1.12345678901234567f;
		double dnum2 = 1.12345678901234567;
		System.out.println(dnum1);
		System.out.println(dnum2);
		boolean stop = true;
		System.out.println(stop);
		String str = "Hello";
		System.out.println(str);
	}

}
