package day9;

public class CardGame {

	public static void main(String[] args) {
		/* 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 알려주는 코드를 작성하세요.
		 * -> 갯수는 불 말고 인트??? 그러면 트루 -> +=1? 
		 * 3개짜리 2개 > 숫자 더큰 1개;
		 * 갯수 비교 후 더 큰 숫자인지 비교
		 * 1~13숫자 중에 
		 * 최대길이 7개, ->3개는 최대2개 가능*/
		
		/*카드 게임 : 실제 포커 게임은 모양과 숫자를 다 고려해야하지만 여기에선 숫자만 고려, 카드는 7장
		 * 			카드는 1~13이 4개씩(하트, 다이아, 세잎, 스페이스)(총 52종류)
		 * - 포커 : 같은 숫자가 4개
		 * - 스트레이트 : 연속된 숫자가 5개이상
		 * - 풀하우스 : 트리플 1+ 페어1 또는 트리플 2
		 * - 트리플 : 같은 숫자가 3개
		 * - 투 페어 : 같은 숫자가 2개씩 2개 => 페어가 2개
		 * - 페어 : 같은 숫자가 2개
		 * - 탑 : 위의 모든 조건이 없는 경우 가장 큰 수
		 * */
		
		int arr[] = new int[] {1,1,2,2,6,6,6};
		int card[] = new int[2];
		//int num = 0;
		int cnt =1, tes = 0, k = 0;
		boolean res = false;
		
		for(int i=0;i<arr.length-1;i+=1) {
			if(arr[i]==arr[i+1]) {
				cnt += 1;
				//num = arr[i];
			}else {
				if(cnt%3==0) {
					res = true;
					//card[tes] = num;
					tes += 1;
					card[k] = arr[i];	//
					k+=1;
				}
				cnt = 1;
			}
		}
		if(cnt %3 == 0) {
			res = true;
			//card[tes] = num;
			tes += 1;
			card[k] = arr[arr.length-1];	//	
		}
		//if(tes == 0){
		//System.out.println("트리플 없음");
		//}else{
		//	for(int i =0; i<tes; i+=1){
		//		System.out.println("card[i]"+" ");
		//}
		if(res) {
			System.out.println(tes+"개 있음");
			System.out.print("내 카드의 스트레이트 숫자: ");
			for(int tmp:card) {							//
				System.out.print(tmp+" ");
			}
			System.out.println();
		}else {
			System.out.println("없음");
		}
		
		
		
		

	}

}
