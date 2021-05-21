package day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapTest1 {

	public static void main(String[] args) {
		/* Map 예제*/
		HashMap<String, String> map = new HashMap<String, String>();
		//put(key, value) : key와 value의 값을 저장 (리턴값이 있음)
		//key의 값이 중복되지 않으면 null을 리턴하고, 중복되면 이전에 저장된 값을 리턴 value
		System.out.println(map.put("과일", "사과"));
		System.out.println(map.put("과일", "포도"));
		//containsKey(객체) : key값에 객체와 일치하는 정보가 있는지 없는지 알려줌
		//containsValue(객체) : value값에 객체와 일치하는 정보가 있는지 없는지 알려줌
		System.out.println("key에 과일이 있습니까? "+ map.containsKey("과일"));
		System.out.println("key에 과일이 있습니까? "+ map.containsKey("포도"));
		System.out.println("value에 과일이 있습니까? "+ map.containsValue("과일"));
		System.out.println("value에 과일이 있습니까? "+ map.containsValue("포도"));
		//get(객체) : key값이 객체와 일치하는 정보의 value값을 가져옴
		System.out.println("key값이 과일인 객체의 value값은?" + map.get("과일") ); 
		
		map.put("학용품", "연필");
		map.put("탈것", "자전거");
		map.put("전자기기", "스마트폰");
		
		/*set을 이용하여 Interator를 사용
		 방법1 : key값들을 set으로 만든 후 만들어진 set을 이용하여 반복문을 사용하는 경우
		 keySet() : 맵의 key값들을 하나의 set으로 만들어주는 메소드*/
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+ " : " + value);
		}
		/*set을 이용하여 Iterator를 사용
		  방법2 : key값과 value값을 가지는 하나의 클래스인 Entry클래스를 이용하는 방법
		  entrySet() : key와 value를 멤버변수로 가지고 있는 Entry 클래스를 이용한 set을 반환하는 메소드 */
		System.out.println("----------------------");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key+" : "+value);
		}
		
		
	}

}
class Entry{
	String key;
	String value; //이런 클래스를 만드는거 -> 이터레이터 이용하려면 키와 value를 하나의 클래스에 넣고서 set으로 만듬
}
