package day15;
//RemoteControl 인터페이스를 구현한 TvRemoteControl 구현 클래스
public class TvRemoteControl implements RemoteControl{
	
	private boolean power;
	private int channel;
	private final int MAX_CHANNEL = 999;
	
	
	@Override
	public void powerOn() { power = true; }

	@Override
	public void powerOff() { power = false; }
	//인터페이스에 있는 메소드를 오버라이딩 안하면 에러남 일반적 공통적 기능인 전원 온오프만 오버라이딩 해주고 나머지 기능들을 따로 추가
	
	public void channelUp() {
		if(!power) {
			return;
		}
		channel++;
		if(channel>MAX_CHANNEL) {
			channel = 1; 
		}
	}
	public void channelDown() {
		if(!power) {
			return;
		}
		channel--;
		if(channel<1) {
			channel = MAX_CHANNEL; 
		}
	}
	public void setChannel(int channel) {
		if(!power) {
			return;
		}
		this.channel = channel;
		if(channel < 1 || channel > MAX_CHANNEL) {
			channel = MAX_CHANNEL;
		}
	}
	
}
