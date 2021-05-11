package day11;

public class MethodTest {

	public static void main(String[] args) {
		// 
		int res = sum(1,2); //해당 메소드 호출한 위치에 리턴값 들어감 //다시 필기하기..
		System.out.println(res);
		int arr[] = new int[] {1,2,3,4,5};
		//System.out.println(sum2(arr)); //매개변수들ㅇ,ㄹ배열ㄹ ㅗ만들어서 전달
		//System.out.println(sum3(1,2,3));
	}
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	/*public static int sum2(int[]arr){
		if() {
			return 0;
	}int res = 0;
	for(int tmp:arr) {
		res +=tmp;
	}
	return res;
}*/
//225p

}
