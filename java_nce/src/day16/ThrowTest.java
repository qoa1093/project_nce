package day16;

import javax.management.RuntimeErrorException;

public class ThrowTest {
		//throw 예외 발생 만들어보는 예제
	public static void main(String[] args) {
		int num = 1;
		try {
			if(num == 1){
				RuntimeException e = new RuntimeException();
				throw e;
				//throw new RuntimeException("예외"); //위의 두줄과 동일한 코드
				//개발자가 원하는 시점에서 예외처리를 하고싶을때 사용하는 명령어
			}
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생");
		}catch(Exception e) {
			System.out.println("예외가 발생");
		}
		//예외는 실행예외가 아니기 때문에 예외처리가 필수이다
		//예외처리를 안한 아래 코드는 에러 발생
		//throw new Exception("예외");
		//RuntimeException은 실행 예외이기 때문에 예외처리를 안해도 에러가 발생하지 않음 @@@널 어쩌구랑 그 실행예외들도 다 동작하고나서야 에러나잖아
		throw new RuntimeException("예외");
	}

}
