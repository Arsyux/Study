package chap11_CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample05_Iterator2 {

	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("lion");
		
		System.out.println(list);
		System.out.println("size : " + list.size());
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String item = it.next();
			System.out.println(item);
			if("cat".equals(item)) {
				// list안의 객체가 삭제됨. -> list를 참조하였기때문
				// 유의해서 사용해야함.
				it.remove();
			}
		}
		
		System.out.println(list);
		System.out.println("size : " + list.size());
	}

}
