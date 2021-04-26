package day1;

public class Cast1 {

	public static void main(String[] args) {
		//타입 변환 : 서로 다른 타입이 있을 때 변환 
		//자동 타입 변환 : 정수를 실수로 변환할때 작은 범위를 큰 범위로 변환할때 
		byte num1 = 1;
		int num2 = num1;
		double dnum1 = num2; // 정수 --->실수 변환할때 자동으로 변환됨 그냥 앞에 00000000만 더 붙이면 됨?
		// 강제 타입 변환 : 자동 타입 변환이 안되는 경우, 강제로 변환 시켜야 함
		int num3 = (int)1.23; //변수나 값 앞에 (변수타입)을 써줘야한다 : 데이터 손실이 발생할 수 있기 때문에 자동변환x
		
		
	}

}
