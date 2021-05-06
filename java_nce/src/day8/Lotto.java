package day8;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// 로또만들기
		
		int user[] = new int[6];
		int min = 1, max = 45;
		init(user, min,max);
		for(int tmp: user) {
			System.out.print(tmp+" ");
		}
		System.out.println();
		
		//당첨번호를 입력
		int lotto[] = new int[6];
		int bonus;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("당첨번호 6개를 입력하세요: ");
		for(int i =0; i<lotto.length;i+=1) {
			lotto[i] = scan.nextInt();
		}
		System.out.print("보너스 번호를 입력하세요: ");
		bonus = scan.nextInt();
		
		scan.close();
		//당첨 등수 확인
		printRank(user, lotto, bonus);

	}
	
	public static boolean contains(int arr[], int count, int num) {
		for(int i=0; i< count; i+=1) {
			if(arr[i]==num) {
				return true;
			}
		}
		return false;
	}
	
	public static void init(int []arr, int min, int max) {
		
		int cnt = 0;
		while(cnt < arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt += 1;
			}
		}
	}
	
	
	/*기능 : 두 배열이 주어지면 두 배열에서 같은 숫자가 몇개인지 알려주는 메소드
	 * 매개변수 : 두 배열 => int[]arr1, int[]arr2 
	 * 리턴타입 : 같은 숫자의 갯수 => int
	 * 메소드명 : getSameCount\
	 * */
	public static int getSameCount(int arr1[], int arr2[]) {
		int cnt = 0;
		for(int tmp:arr1) {
			if(contains(arr2, arr2.length, tmp)){
				cnt+=1;
			}
		}
		return cnt;
	}
	
	/*기능 : 자동 생성번호와 당첨번호, 보너스 번호가 주어지면 몇등인지 알려주는 메소드
	 * 	 단, 꽝은 0등으로 표현
	 * 매개변수 : 자동생성번호, 당첨번호, 보너스 번호
	 * 			=> int[]user, int[]lotto, int bonus
	 * 리턴타입 : 당첨 등수 => 정수 = int 
	 * 메소드명 : rank
	 * */
	public static int rank(int user[], int lotto[], int bonus) {
		int res = 0; //등수
		int count = getSameCount(user, lotto); //아래와 동일
		switch(count) {
		case 6: res = 1;	break;
		case 5:
			if(contains(user, user.length, bonus)) {		//이하 동일한 코드
				res = 2;
			}else {
				res = 3;
			}
			//res = contains(user, user.length, bonus)? 2:3; //조건선택연산자
			break;
		case 4: res = 4;	break;
		case 3: res = 5;	break;
		}
		return res;
	}
	/* 기능 : 자동생성번호와 로또번호, 보너스가 주어지면 당첨 등수를 출력하는 메소드
	 * 매개변수 : 자동생성번호, 당첨번호, 보너스
	 * 			=> int []user, int[]lotto, int bonus
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int []user, int[]lotto, int bonus) {
		int rank = rank(user, lotto, bonus);
		switch(rank){
			case 1,2,3,4,5:
				System.out.println(rank+"등입니다.");
				break;
			default:
				System.out.println("꽝입니다.");
		}
	}

}
