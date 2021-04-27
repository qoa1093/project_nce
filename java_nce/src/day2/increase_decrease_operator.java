package day2;

public class increase_decrease_operator {

	public static void main(String[] args) {
		//* 증감연산자 예제03 
		//(전위형(1증가 후 동작), 후위형(동작 후 1증가))
		
		
		int num1 = 10, num2 = 10;
		System.out.println("  num1= " + num1 + ",   num2 = " + num2); //10, 10
		System.out.println("++num1= " + ++num1 + ", num2++ = " + num2++); //11, 10 : 중간과정이 변함, 동작=콘솔에 출력됨 
		System.out.println("  num1= " + num1 + ",   num2 = " + num2);//11, 11
		/*따라서 전위형은 증가한 상태가 먼저 출력, 후위형은 출력부터 하고 다음 작업에서 증가함*/
		num1++;
		++num1;
		//num1 출력시 얼마?
		//13아닌감
		
		num1 = 10;
		num2 = 10;
		System.out.println("  num1= " + num1 + ",   num2 = " + num2); 
		num1++; //++num1;
		System.out.println("++num1= " + num1 + ", num2++ = " + num2);   
		++num2; //num2++;
		System.out.println("  num1= " + num1 + ",   num2 = " + num2);
		
		
		
		
	}

}
