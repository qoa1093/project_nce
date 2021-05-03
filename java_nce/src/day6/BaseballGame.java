package day6;

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/*숫자야구게임
		 * 
		 * 1~9 사이의 중복되지 않은 3개의 정수를 랜덤으로 생성
		 * -b : 숫자는 있지만 위치는 다른경우
		 * -s : 숫자도 있고 위치가 같은 경우
		 * -o : 일치하는 숫자가 하나도 없는 경우 */
		
		int com[] = new int[3]; //컴터가 랜덤숫자 저장
		int user[] = new int[3]; //사용자가 숫자 입력
		int strike; //스트라이크 갯수
		int ball;  //볼의 갯수
		int cnt = 0; //컴퓨터가 랜덤을 생성한(중복x)숫자 배열에 저장한 '갯수'
		int min = 1, max =9;
		int r; //랜덤으로 생성된 숫자를 저장
		int i,k;
		boolean isDuplicated; // 배열에 중복된 값 있는지 확인 후 정답이면 출력 종료
		
		//랜덤숫자(중복확인 후 생성)
		//배열에 3개 저장될때까지 반복
		
		while(cnt < 3){
			//min~max사이의 랜덤한 숫자 생성 후 생성한 숫자 중복비교
			r = (int)(Math.random()*(max-min+1)+min);
			isDuplicated = false;
			
			//1 1 6 7 숫자 생성하면 0번지부터 비교 
			//1 6 쌓이는 cnt
			//배열의 0번지부터 cnt 비교해서 중복여부를 확인
			for(i=0;i<cnt;i+=1) {
				//중복체크하여 중복되면 중복됐다고 저장
				//랜덤한 숫자와 배열의 i번지의 값이 같으면 isDuplicated를 true로
				if(r == com[i]) {
					isDuplicated = true;
				}
			}
			//중복되지 않으면 배열에 저장 후 저장한 갯수(cnt)를 1개 증가
			if(!isDuplicated) {
				com[cnt] = r;
				cnt+=1;
			}
		}
		
		
		//컴퓨터가 생성한 숫자를 출력(테스트용)
		for(i=0;i<cnt;i+=1) {
			System.out.print(com[i]+ " ");
		}
		System.out.println();
		
		
		Scanner scan = new Scanner(System.in);
		//게임 시작해서 3s 나올때까지 반복
		do{
			//사용자가 중복되지 않은 세수를 입력
			System.out.print("입력하세요: ");
			for(i=0;i<user.length;i+=1) {
				user[i] = scan.nextInt();
			}
			
			//볼과 스트라이크 갯수를 셈
			ball = 0; //@@@얘가 어려웠다잉 ㅠㅠ
			strike = 0;
			//com배열과 user배열에서 같은 번지를 비교하여 같은 숫자가 있으면 strike +=1(++)
			for(i=0;i<cnt;i+=1) {
				if(com[i] == user[i]) {
					strike +=1;
				}
			}
			//com배열과 user배열에서 다른 번지를 비교하여 같은 숫자가 있으면 ball을 증가(깃헙코드는 편법 이게 정석)
			//com[0]과 user[1], user[2] 비교
			//com[1]과 user[0], user[2] 비교
			//com[2]과 user[0], user[1] 비교
			for(i=0;i<com.length;i+=1) {
				for(k=0;k<user.length;k+=1) {
					if(i==k) {						//사실상 스트라이크 같은 위치 같은 값인거니까
						continue;
					}
					if(com[i] == user[k]) {
						ball+=1;
					}
				}
			}
			
			//볼과 스트라이크 아웃 판별 후 출력
			//스트라이크는 0스트라이크가 아닐때 ?s를 출력
			if(strike !=0) {
				System.out.print(strike + "S");
			}
			//볼은 0볼이 아니면 ?b를 출력
			if(ball !=0) {
				System.out.print(ball + "B");
			}
			//o : 볼이 0이고 스트라이크가 0이면 o를 출력
			if(ball==0 && strike ==0) {
				System.out.print("O");
			}
			//줄바꿈
			System.out.println();
		}while(strike !=3);
		System.out.println("정답입니다.");
		scan.close();
	}

}
