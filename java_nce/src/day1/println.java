package day1;

public class println {

	public static void main(String[] args) {
		/* System.out.println(): ()안 내용 콘솔에 출력하는 메소드
		 * 내용 출력 후 엔터 쳐야함 \n 자동으로 엔터 들어감
		 * System.out.println(정수,문자열,실수,논리형,문자 모두 가능)
		 * */
		System.out.println("Hello");// ln이 왜붙는 걸까 궁금하다
		System.out.println(1);
		System.out.println(3.14);
		System.out.println(true);
		System.out.println('A');
		System.out.print(1); // ln 안붙으면 띄어쓰기 안한대 <- \n 기능이랑 같나봐
		System.out.print(3.14); // 자바는 여기서 띄어쓰기 명령어 뭐로 넣지?? 밑에 애랑 붙음 ㅠㅠ
		
		System.out.println(1+2+3);
		//문자열1 + 정수2 => 문자열 12가 됨
		//문자열 12 + 정수3 => 문자열 123
		System.out.println("1"+2+3); //123출력
		//문자열 1과 2를 먼저 더하는 것이 아니라 정수2와 정수3을 더한 후 문자열 1과 더함 => 문자열1과 정수 5를 더함
		System.out.println("1"+(2+3)); // 15
		System.out.println(1+2+"3"); // 33
		System.out.println('1'+3); //왜 52가 나오지? 먼일이고 : 아스키코드표 문자1은 정수로 49지정되어있어서
	

	}

}
