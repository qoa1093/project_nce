package day5;

public class Array2 {

	public static void main(String[] args) {
		//5개짜리 정수 배열에 1부터 5까지 차례대로 저장 후 출력하는 예제
		
		int arr[] = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.print(arr[0]+" ");
		System.out.print(arr[1]+" ");
		System.out.print(arr[3]+" ");
		
		
		int i;
		for(i=0;i<5;i+=1) {					//실수의 경우엔 다르지만 정수의 경우 <=4와 <5는 같음. 배열강조위해.
			arr[i] = i + 1;
			System.out.print(arr[i]+ " ");
		}
		
	}

}
