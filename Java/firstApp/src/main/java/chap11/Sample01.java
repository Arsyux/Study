package chap11;

import java.util.ArrayList;
import java.util.List;

public class Sample01 {

	public static void main(String[] args) {
		// Collections Framework
		// Collection과 Map은 인터페이스로 되어 있음.
		// Hash - 해시는 값이 중복될 수 없다는 유니크(Unique)한 특징이 있음.
		// Tree - 이진 트리 순회 방법 중에 중위 순회(In-order traversal) 방식으로 처리됨.
		// Collection을 상속받는 인터페이스나 클래스
		// Collection -> List, Set
		// - List -> ArrayList, LinkedList, Vector
		//   - Vector -> Stack
		// - Set -> HashSet, SortedSet
		//   - SortedSet -> TreeSet
		
		// ArrayList
		// add(int index, E element)
		// add(E e)
		List<String> arr = new ArrayList<>();
		arr.add("하나");
		arr.add("둘");
		arr.add("셋");
		arr.add("넷");
		arr.add("다섯");
		
		// 3번째 위치에 삽입
		arr.add(2, "둘의 반");
		
		for(String a : arr) {
			System.out.println(a);
		}
		
		System.out.println("-----");
		// set(int index, E element)
		arr.set(2, "2.5");
		
		for(String a : arr) {
			System.out.println(a);
		}
		
		System.out.println("-----");
		
		// remove(int index)
		arr.remove(2);

		for(String a : arr) {
			System.out.println(a);
		}

		System.out.println("-----");
		
		List<String> arr2 = new ArrayList<>();
		arr2.add("하나");
		arr2.add("둘");

		// removeAll(Collection<?> c)
		arr.removeAll(arr2);

		for(String a : arr) {
			System.out.println(a);
		}

		System.out.println("-----");
		
		// get(int index)
		// size()
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
