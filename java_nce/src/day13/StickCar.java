package day13;

public class StickCar extends Car {
	//생성자를 만들어주면 해결됨
	public StickCar(String type, String company) {
		super(type, company);
		super.setGear('1');
	}
	@Override
	public void setGear(char gear) {
		// 수동은 기어값이 D올수 없음. 기어값이 D,N등 다른 값이 오면 1단으로 설정
		switch(gear) {
		case '1','2','3','4','5','r':
			super.setGear(gear);
			
			break;
		default:
			super.setGear('1');
		
		}
	}
}
