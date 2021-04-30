package day5;

public class Array4 {

	public static void main(String[] args) {
		/* 1~10 사이의 정수 3개를 랜덤으로 생성하여 배열에 저장한 후					@@@이해못함
		 * 생성된 값들이 중복되었는지 안되었는지 확인하는 코드를 작성하세요.
		 * 
		 * */
		int min = 1, max = 10, i;
		int arr[] = new int[3];
		System.out.println("랜덤: ");
		
		for(i=0;i<arr.length;i+=1) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
		/*1차 작성코드
		 * for(i=0;i<arr.length;i+=1) {					//조건식 = i<arr.length -1
			if() {
				System.out.println("중복ㄴ");
			}else {
				System.out.println("중복");
				break;
			}
		}*/
		
		int k;
		boolean isDuplicated = false;
		  for(i=0; i<arr.length-1;i+=1){
		  	for(k=i+1; k<arr.length;k+=1){
		  		if(arr[i] == arr[k]){
		  		isDuplicated = true;
		  		}
		  	}
		  }
		  if(isDuplicated){
		  		System.out.println("중복");
		  }else{
		  		System.out.println("중복 아님");
		  }
		
		
		
		/*힌트 :
		 * A B C D E		= 의 갯수 : length		
		 * 
		 * AB AC AD AE		01 02 03 04		// i = 0 		k = i + 1
		 * BC BD DE			12 13 14		// i = 1
		 * CD CE			23 24			// i = 2
		 * DE				34				// i = 3
		 *  5줄 / 갯수-1
		 *  비교할 숫자는 갯수 4개이지만 횟수는 다섯번이므로 
		 *  
		 * =>이중반복문
		 * 
		 * 
		 * 
		 * L: for(i=0; i<arr.length-1;i+=1){
		 * 		for(k=i+1; k<arr.length;k+1){
		 * 			if(arr[i] == arr[k]){
		 * 				system.out.println("중복");
		 * 				break L;					//콘솔창에서 중복 확인할 수 없다는 문제
		 * 			}
		 * 		}
		 * }
		 * 
		 * #답:
		 * boolean isDuplicated(중복됨이란 뜻) = false;
		 * for(i=0; i<arr.length-1;i+=1){
		 * 		for(k=i+1; k<arr.length;k+=1){
		 * 			if(arr[i] == arr[k]){
		 * 				isDuplicated = true;
		 * 			}
		 * 		}
		 * }
		 * if(isDuplicated){
		 * 		system.out.println("중복");
		 * }else{
		 * 		system.out.println("중복 아님");
		 * }
		 * 	
		 * =>동작함
		 * */
		
		
		
		/* 하다만거
			for(i=0;i<arr.length;i+=1){
			System.out.print(arr[i]+" ");
			}    */

	}

}
