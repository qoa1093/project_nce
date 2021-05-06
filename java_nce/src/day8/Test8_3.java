package day8;

import java.util.Scanner;

public class Test8_3 {

	public static void main(String[] args) {
		/* 4개의 성적을 입력받아 합격인지 불합격인지 판별하는 코드를 작성하세요.
		 * 합격기준
		 *  -모든 성적이 과락없어야
		 *  -평균 60점 이상
		 *  과락 : 성적이 40점 미만인 경우
		 *  예시 
		 *  성적 : 40 30 100 100
		 *  불합격입니다.
		 *  예시
		 *  성적 : 60 40 100 100
		 *  합격입니다.
		 *  성적 : 40 50 40 60
		 *  불합격입니다.
		 *  */ 
		/*Scanner scan = new Scanner(System.in);
		
		int score[] = new int[4];
		int cnt = 0;
		System.out.print("성적을 입력하세요: ");
		for(int i=0;i<score.length;i+=1) {
			
			score[i]=scan.nextInt();
			cnt += score[i];
		}
		boolean sh = false;
		System.out.println((cnt/score.length)<60);
		
		for(int i=0;i<score.length;i+=1) {
			if(score[i]<40 || (cnt/score.length)<60) {		//@@@ 헷갈려
				sh = true;
				break;
				
			}else{
				sh = false;
			}
		}	
		if(sh == true) {
			System.out.println("불합격");
		}else {
			System.out.println("합격");
		}*/
		
		//강사님코드
		//성적을 입력
		int []score = new int[4];
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<score.length;i+=1) {
			score[i] = scan.nextInt();
			
		}
		scan.close();
		
		
		//합격여부 결정
		//평균이 60이상
		int sum = 0;
		boolean pass = true; //false : 불합격, true : 합격
		
		for(int tmp:score) {
			sum += tmp;
		}
		double avg = (double)sum/score.length; //정확한 값 위해 형 변환
		if(avg < 60) {
			pass = false;
		}
		//과락이 있는지 없는지
		for(int tmp: score) {
			if(tmp<40) {
				pass = false;
			}
		}
		//합격여부판별
		if(pass) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}

		
		
		

	}

}
