package day6;

import java.util.Calendar;

public class Enum3 {

	public static void main(String[] args) {
		/*열거형은 아니지만 열거형과 비슷하게 의미전달을 하는 예제*/
		Calendar now = Calendar.getInstance(); 		//현재 날짜와 시간 알려줌
		int year = now.get(Calendar.YEAR);			//now.get(1)현재의 날짜의 년도 알려줌
		int month = now.get(Calendar.MONTH)+1;		//now.get(2)현재의 날짜의 월을 알려줌(0부터시작) => +1해줘야함 의미명확하게 전달하기 위해 숫자지만 이렇게 씀
		System.out.println(year + "sus" + month + "월");

	}

}
