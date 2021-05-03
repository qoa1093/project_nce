package day6;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		/*과제2 : 숫자 야구 게임 만들어보기 */

		int i,k, min = 1, max = 10;
		int arr[] = new int[3];


		for(;;) {
			for(i=0;i<arr.length;i+=1) {
				arr[i] = (int)(Math.random()*(max-min+1)+min);
			}
			System.out.println("테스트용:"+arr[0]+" "+ arr[1]+" "+arr[2]);

			boolean ran = false;
			for(i=0;i<arr.length-1;i+=1) {
				for(k=i+1;k<arr.length;k+=1) {
					if(arr[i] == arr[k]) {
						ran = true;			
					}
				}
			}

			if(ran) {
				System.out.println("테스트용: 중복");
				continue;
			}else {
				System.out.println("테스트용: 중복아님");
				break;
			}
		}
		//여기까지 중복확인하고 랜덤값 입력함수 끝(기본세팅완료)
		Scanner scan = new Scanner(System.in);
		int j, num[] = new int[3];


		for(;;) {
			System.out.print("입력하세요(1~9): ");
			for(i=0;i<num.length;i+=1) {
				num[i] = scan.nextInt();		//값 입력받기(무한루프)
			}


			for(i=0,j=0;i<num.length;i+=1) {	//위치와 값 비교하기
				if(num[i] == arr[i]) {
					j+=1;
				}
			}
			/*여기부터 막힘 ㅠㅠ...*/
			int r = 0;
			boolean ran = false;
			for(i=0;i<num.length-1;i+=1) {		//위치 상관없이 값만 비교하기
				for(k=i+1;k<arr.length;k+=1) {
					if(num[i] == arr[k]) {
						ran = true;
						r += 1;	
					}

				}
			}
			/*바로 밑 코드 : 값만 비교하기 부분 막힘*/
			if(ran) {
				System.out.println(r+"b");
			}		
			if(0<j && j<3) {					//s와 o 해결
				System.out.println(j+"s ");
				continue;
			}
			if(j==3) {
				System.out.print("정답입니다.");
				break;
			}else {
				System.out.println("o");
			}

			//break; //임시로
		}
		System.out.println("테스트용: 무한루프 확인용");


		/* 랜덤수 -> arr에 3개 저장(for문 활용), 
		 * -> 랜덤수끼리 비교(안긴 for문*2)
		 * 테스트- 랜덤수 잘 저장되었는지 프린트 확인 후,
		 * do while로 해볼까? (초기값 증감패스 ..?)
		 * ----해결
		 * 
		 * for문으로 한다면:
		 * for(){
		 * 출력)1~9사이의 숫자를 3개 입력하세요:
		 * 정수 i j k에 각각 입력받음(스캔)
		 * ###if(i==arr[0] && j ==arr[1] && k == arr[2]){
		 * 	출력)정답입니다.
		 *  break;
		 * 	}else if(근데 다 하나씩 비교해볼거면 이프문 너무 길어지는데
		 * 걍 for문으로 아까처럼 해결보는게 낫지 않나? 포의 지옥 ㅎ)####
		 * ---해결
		 * 
		 * 1. 입력받은값 각각 arr[]와 비교
		 * if(){
		 * -> true의 갯수가 1개면 1s, 2개면 2s 3개면 3s 
		 * 		3s가 되면 정답입니다 출력 후 종료 break;  }
		 * ---해결
		 * 
		 * 2. else if(){
		 * -> 입력받은 값과 arr[]의 값을 하나씩 비교(순서중요하지 않음)
		 * 수끼리 비교(안긴 for문 확인해보기 : 중복확인해서 중복이 있으면 
		 * 그 각각마다 1b씩 출력 최대 3b)
		 * }
		 *##근데 어차피 위에거는 가로세로 확인하는거고 밑에거는 가로 한줄 확인이니까
		 *걍 밑에거 먼저하고 통과되면 그다음에 불 넣어서 트루갯수 확인하면 되는거아닌가?
		 *그러고 브레이크 하고 ..? 그럼 엘스까지 안가나?아닌데 갈거같은디.. 
		 *
		 *
		 * else: (일치하는 숫자가 하나도 없을경우 o 출력) 
		 * ---해결
		 * }
		 * 
		 * 
		 * 
		*/
	}

}
