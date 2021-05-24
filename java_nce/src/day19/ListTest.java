package day19;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("안녕");
		list.add("hi");
		list.add("hello");
		for(String tmp : list) {
			System.out.println(tmp);
		}

	}

}
