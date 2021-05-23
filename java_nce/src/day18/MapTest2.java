package day18;

import java.util.HashMap;
import java.util.Scanner;

import day2.signOperator;


public class MapTest2 {
	public static HashMap<String, String> sign = new HashMap<String, String>();

	public static void main(String[] args) {
		/* 다음 두 기능을 가진 프로그램을 작성하세요.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * Map을 이용하여 회원정보를 저장하고, 로그인 시도 시 로그인 성공하면 성공했다고 알려주는 기능
		 * 예시>
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴선택 : 1
		 * 회원가입 
		 * 아이디 : ㅇㄹㅇ
		 * 비밀번호 : ㅇㄹㄴ
		 * 회원가입되었습니다.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴선택 : 1
		 * 아이디 : ㅇㄹㅇ
		 * ======이미 가입된 회원입니다.=====
		 * 메뉴 선택 : 2
		 * 아이디 ㅇㄹㅇ
		 * 비밀번호 : ㅇㄹㄴ
		 * 로그인 성공
		 * 메뉴 선택 : 2
		 * 아이디 ㅇㄹㅅ
		 * 비밀번호 : ㅇㄹㄴ
		 * 로그인 실패
		 * */
		//반복문
			//메뉴 출력
			//메뉴 입력
			//입력받은 메뉴에 따른 기능
				//회원가입 기능
					//아이디 입력
					//가입된 아이디가 아니면 비밀번호 입력 후 아이디와 비밀번호를 저장
					//가입된 아이디이면 이미 가입된 아이디라고 출력
				//로그인 기능
					//아이디 입력
					//비밀번호 입력
					//아이디와 비밀번호가 일치하는지 확인하여 같으면 로그인 성공
					//다르면 로그인 실패라고 출력
				//종료
					
		
		String id, pw;
		int k;
		Scanner scan = new Scanner(System.in);
		
		
		do{
			System.out.println(" 1. 회원가입 \n 2. 로그인 \n 3. 종료 ");
			System.out.print("메뉴선택 : ");
			 k = scan.nextInt();
			if(k!=1 && k!=2 && k!=3) {
				System.out.println("잘못된 입력입니다. 다시 번호를 입력하세요.");
			}
			switch(k) {
			case 1: 
				System.out.println("회원가입");
				System.out.print("아이디 : ");
				id = scan.next();
				if(nonsignup(id)) {
					System.out.println("=====이미 가입된 회원입니다.=====");
					continue;
				}
				System.out.print("비밀번호 : ");
				pw = scan.next();
				sign.put(id, pw);
				System.out.println("회원 가입되었습니다.");
				break;
				
				//signup(scan.next(), scan.next());
			case 2: 
				System.out.print("아이디 : ");
				id = scan.next();
				System.out.print("비밀번호 : ");
				pw = scan.next();
				if(login(id, pw)) {
					System.out.println("로그인 성공");
					break;
				}else {
					System.out.println("로그인 실패");
					break;
				}
			}
		}while(k!=3);
		
		/*if(k==3) {		// do while -> while(true), switch이전에 브레이크문 넣어주기
			break;
		  }*/

	}
	//회원가입 메소드
	//가입된 아이디인지 아닌지 확인하는 메소드
	public static boolean nonsignup(String id) {
		if(sign.containsKey(id)) {
			return true;
		}
		return false;
		}
			
	
	//로그인 메소드
	public static boolean login(String id, String pw) {
		if(sign.containsKey(id)&&sign.containsValue(pw)) {
			return true;
		}
		return false;
	}

}

