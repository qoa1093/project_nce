package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/*Set 메소드 예제*/
		HashSet<Integer> set = new HashSet<Integer>(); //int는 안됨 이퀄로 확인해서
		//add(객체) : set에 객체를 추가
		//add(번지, 객체)
		set.add(10);
		//번지로 접근하는건 없음.
		set.add(10);
		set.add(18);
		set.add(14);
		set.add(16);
		//size() : set의 크기
		System.out.println("set의 크기 : "+set.size());
		//contains(객체) : 객체가 있는지 없는지 확인
		System.out.println("set에 10이 있습니까? "+ set.contains(10));
		System.out.println("set에 11이 있습니까? "+ set.contains(11));
		//isEmpty() : set이 비었는지 아닌지 확인
		System.out.println("set이 비어있습니까? "+ set.isEmpty());
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) { //다음에 선택할 객체가 있는지 여부를 알려주는 메소드. next는 다음걸 가져옴.
			Integer tmp = (Integer)it.next();	//부모클래스 객체 자식클래스로 자동형변환 안되서 위아래 ite지우면 에러남 it.next가 오브젝트로 가져와서
			System.out.print(tmp+" ");
		}
		System.out.println();
		//remove(객체) : 객체와 일치하는 내용을 삭제하고 삭제 성공 여부를 알림
		System.out.println("set에 10의 값이 삭제되었습니까? "+ set.remove(10));
		System.out.println("set에 10의 값이 삭제되었습니까? "+ set.remove(101));
		//clear() : 비움
		set.clear();
		System.out.println("set의 크기 : "+ set.size());
		
		
		
		

	}

}
