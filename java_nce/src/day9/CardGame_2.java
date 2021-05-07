package day9;

public class CardGame_2 {

	public static void main(String[] args) {
		/* 카드 게임 : 실제 포커 게임은 모양과 숫자를 다 고려해야하지만 여기에선 숫자만 고려, 카드는 7장
		 * 			카드는 1~13이 4개씩(하트, 다이아, 세잎, 스페이스)(총 52종류)
		 * - 포커 : 같은 숫자가 4개
		 * - 스트레이트 : 연속된 숫자가 5개이상
		 * - 풀하우스 : 트리플 1+ 페어1(2페어) 또는 트리플 2
		 * - 트리플 : 같은 숫자가 3개
		 * - 투 페어 : 같은 숫자가 2개씩 2개 => 페어가 2개
		 * - 페어 : 같은 숫자가 2개
		 * - 탑 : 위의 모든 조건이 없는 경우 가장 큰 수
		 * 순서대로 확인하면 밑에거 확인 ㄴㄴ*/
		
		//다음주 정렬까지 살펴보고 클래스와 멤버변수 객체변수 다시 나감 다음주부터...
		//###주말과제 : 카드가 주어지면 해당 카드의 가장 큰 등급을 출력하는 코드를 작성하세요.
		//아래와같이 풀하우스, 트리플, 페어로 판별 가능한 경우 풀하우스 하나만 출력 아래는 1풀하우스입니다라고 출력
		
		int card[] = new int[] {1,2,2,3,4,5,6};
		
		System.out.println("포커: "+ poker(card));
		
		System.out.print("트리플: "+triple(card));
		
		System.out.println();
		System.out.println("원페어: "+ onePair(card));
		System.out.print("투페어: ");
		int []res = twoPair(card);
		if(res == null) {
			System.out.println(0);
		}else {
			for(int tmp : res) {
				System.out.print(tmp+ " ");		//3페어도 2페어로 출력
			}
		}
		
		System.out.println("풀하우스: "+ fullHouse(card));
		//System.out.println("페어: "+pair(card));
		System.out.println("스트레이트: "+ straight(card));
		
		//참조변수의 경우 null이 들어갈수있기 때문에 참조변수를 이용하는 경우 null인지 아닌지 체크하고 이용해야함
		int []arr3 =null;
		if(arr3 !=null/*예외 발생 방지 : SCE*/ && arr3.length ==2) {
			System.out.println("12");
		}

	}
	/* 포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열 갯수 7개 중 중복된 숫자가 4개인 경우 있는지 없는지 확인하기 //
	 * #배열이 주어지면 배열에 포커가 있는지 확인하여 있으면 해당 숫자를 없으면 0을 알려주는 메소드
	 * 
	 * 매개변수 : 배열, 같은 숫자가 몇개인지 => int arr[], num
	 * # 배열 => int [] card
	 * 
	 * 리턴타입 : 중복된 숫자의 여부 => boolean
	 * # 포커의 숫자 => 정수 => int
	 * 
	 * 메소드명 : poker*/
	public static int poker(int[]card) {
		int cnt = 1, res = 0;
		for(int i = 0; i < card.length-1; i += 1) {
			if(card[i] == card[i+1]) {
				cnt += 1;
				if(cnt == 4) {
					return card[i];
				}
				
			}else {
				cnt=1;
			}
		}
		return 0;
	}
	/*트리플을 확인할 수 있는 메소드. 트리플이 있다면 해당 트리플의 숫자를 확인할 수 있는 메소드를 만들어야 한다.
	 * 기능 : 배열이 주어지면 해당 배열 내에서 트리플이 있는지 확인하여 있으면 숫자를 없으면 0을 리턴
	 * #배열에 트리플이 있으면 해당 트리플으 ㅣ숫자들을 알려주는 메소드 없으면 null을 알려줌
	 * 매개변수 : 배열 => arr[]
	 * # 배열 => in []card
	 * 리턴타입 : 트리플의 갯수? -> int
	 * # 트리플의 숫자들 => 정수배열 => int[]
	 * 11,13 => 1113
	 * 	0
	 *  3
	 * 메소드명 : tripleList
	 * */
	public static int[] tripleList(int[]card) {
		int num = 0,res = 0, cnt = 1;
		int []triple = new int[2];
		
		for(int i =0; i<card.length-1; i+=1) {
			if(card[i] == card[i+1]) {
				cnt += 1;
				num = card[i];
			}else {
				if(cnt == 3) {
					triple[res] = num;
					res += 1;
				}
				cnt = 1;
			}
		}
		if(cnt == 3) {
			triple[res] = num;
			res += 1;
		}
		
		
		//트리플이 없으면
		if(res == 0) {
			return null;
		}else if(res == 2){
			return triple;
		}else {
			int [] tmp = new int[1];
			tmp[0] = triple[0];
			return tmp;
		}
	}
	/*트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능 : 배열에 트리플이 있으면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 => int[]card
	 * 리턴타입 : 트리플인 숫자 => 정수 =>int
	 * 메소드명 : triple
	 * */
	public static int triple(int []card) {
		int [] res = tripleList(card);
		if(res == null || res.length == 2) {
				return 0;
		}
		return res[0];
	}
	/* 페어를 확인할 수 있는 메소드를 정리해보세요. 
	 * 페어가 있다면 해당 페어의 숫자들을 알려주고 없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 * 기능 : 배열에서 페어가 있으면 페어의 숫자들을 알려주고, 없으면 null을 알려주는 메소드
	 * 매개변수 : int []card
	 * 리턴타입 : 페어의 숫자들 => 정수배열 => int[]
	 * 메소드명 : pairList
	 * */
	public static int[] pairList(int []card) {
		
		int []pair = new int[3];	//페어의 숫자들
		int num = 0, res = 0, /*페어의 갯수*/cnt = 1;
		for(int i =0; i<card.length-1; i+=1) {
			if(card[i] == card[i+1]) {
				cnt += 1;
				num = card[i];
			}else {	//페어이면
				if(cnt == 2) {
					pair[res] = num;
					res += 1;
				}
				cnt = 1;
			}
		}
		if(cnt == 2) {
			pair[res] = num;
			res += 1;
		}
		
		
		//페어가 없으면
		if(res == 0) {
			return null;
		}else if(res < 3){
			int []tmpArr= new int[res];
			for(int i =0; i<res; i+=1) {
				tmpArr[i] = pair[i];
			}
			return tmpArr;
		}
		return pair;
	}
	/*원페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열에 원페어가 있으면 해당 페어 숫자를, 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 int[]card
	 * 리턴타입 :페어 숫자 => 정수
	 * 메소드명 : onePair*/
	public static int onePair(int[]card) {
		int [] res = pairList(card);
		if(res != null && res.length == 1) {
				return res[0];
		}
		return 0;
	}
	/*투페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열에 투페어가 있으면 해당 페어 숫자들을 없으면 null을 알려주는 메소드
	 * 매개변수 : 배열 => int[]card
	 * 리턴타입 : 페어숫자들 => 정수배열 =>int[]
	 * 메소드명 : twoPair*/
	public static int[] twoPair(int[]card) {
		int [] res = pairList(card);
		if(res == null || res.length == 1) {
				return null;
		}
		return res;
	}
	/*풀하우스를 확인할 수 있는 메소드를 정리해보세요.
	 *  기능 : 배열에서 트리플1과 페어1/페어2가 있거나 트리플 2가 있으면 해당 페어 숫자를, 없으면 0을 알려주는 메소드
	 *  #풀하우스가 있으면 풀하우스 숫자를 없으면 0을 알려주는 메소드
	 *  2 2 2 3 3 4 5 => 2 동일한 숫자 풀하우스 만들수 없어서 하나만 확인해도 가능
	 *  2 2 2 9 9 9 10 =>9
	 *  매개변수 : 배열 int[]card
	 *  리턴타입 : 풀하우스 숫자 => int
	 *  메소드명 : fullHouse
	 *  
	 *  //2 2 9 9 10 11 12
	 *	//1 1 9 9 10 11 12
	 *  */
	public static int fullHouse(int []card) {
		int [] triple = tripleList(card);
		//트리플이 없으면 풀하우스가 될 수 없기 대문에 0을 리턴
		if(triple == null) {
			return 0;
		}
		//트리플이 2개이면 풀하우스
		//트리플리스트를 이용
		if(triple.length == 2) {
			if(triple[0]> triple[1]) {
				return triple[0];
			}
			return triple[1];
		}
		//트리플이 2개가 아니면
		int[]pair = pairList(card);
		if(pair != null){
			return triple[0];
		}
		//트리플이 1개, 페어가 1개 이상이면 풀하우스
		//트리플과 페어리스트를 이용
		//아니면 풀하우스가 아님
		return 0;
		/* 1차 작성코드
		 * if(res.length == 2) {
				return res;
		}else if(res.length ==1 && tes.length>= 1) {
				return res[0];	
		}
		return 0; */
	}
	/* 스트레이트를 확인할 수 있는 메소드를 정리해보세요.
	 * 10 11 12 13 A 원래는 마운틴이라고 해서 스트레이트지만 제외함.
	 * 백스트레이트라고해서 1,2,3,4,5가 있는데 여기서는 그냥 5 스트레이트로 판단
	 * 기능 :배열중에서 i가 +=1씩 증가하면 arr[i]의 값도 1씩 증가하는게 5회 연속되면 스트레이트로 확인하고 스트레이트 출력
	 * # 배열에 스트레이트가 있으면 스트레이트 중 가장 큰 수를 알려주고 없으면 0을 알려주는 메소드 
	 * 매개변수 : arr[i]
	 * # 배열 => int []card 
	 * 리턴타입 : 연속된 숫자 5개중 마지막 숫자 하나 확인 => 정수니까 =>int
	 * # 스트레이트 중 가장 큰 수 => 정수 =>int
	 * 메소드명 : straight
	 * *
	 */
	//1,1,3,4,5,6,7
	public static int straight(int[]card) {
		int cnt = 1, num = 0;
		for(int i = 0; i<card.length-1;i+=1) {
			if(card[i] ==card[i+1]) {
				continue;
			}
			if(card[i] +1 ==card[i+1]) {
				cnt +=1;
				num = card[i+1];
			}else {
				if(cnt>=5) {
					return num;
				}
				cnt = 1;
			}
		}
		//스트레이트가 마지막 숫자를 포함할때
		if(cnt>=5) {
			return num;
		}
		return 0;
		
		/*내 코드
		 * for(int i=1;i<card.length-1;i+=1) {
			if(card[i-1] == card[i]-1) {
				cnt += 1;
			}			
			else {
				if(cnt >= 5) {
					num = card[i];		// @@@루프 돌아갈때 넣어주면 깔끔
					return num;
				}
				cnt = 1;
			}
			
		}
		if(cnt>=5) {
			return num;
		}
		else if(num != 0) {
			return num;
		}
		return 0;*/
	}

}
