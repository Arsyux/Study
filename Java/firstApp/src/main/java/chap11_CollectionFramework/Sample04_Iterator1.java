package chap11_CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sample04_Iterator1 {

	public static void main(String[] args) {
		// Iterator의 주요 메서드 API
		// forEachRemaining() -> 모든 요소가 처리되거나 작업에서 예외가 발생할 때까지 나머지 각 요소에 대해서
		// 지정된 작업을 수행함. 나중에 람다식과 함께 사용.
		// hasNext() -> 다음 요소가 있으면 true를 반환함
		// next() -> 다음 요소를 반환함. Stack.pop()과 달리 데이터삭제없이 다음 데이터 위치로 이동함.
		// remove() -> 이 반복자가 반환한 마지막 요소를 기본 컬렉션에서 제거함.
		List<String> list = new ArrayList<String>();

		list.add("dog");
		list.add("cat");
		list.add("lion");

		System.out.println("1. forEach");
		list.forEach((String x) -> System.out.println(x));

		System.out.println("\n2. for문을 활용한 출력");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("\n3. 향상된 for문");
		for (String item : list) {
			System.out.println(item);
		}

		System.out.println("\n4. Iterator를 활용한 출력");
		Iterator<String> it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		System.out.println("\n5. Iterator를 활용한 출력(람다식)");
		Iterator<String> it2 = list.iterator();
		it2.forEachRemaining((n) -> System.out.println(n));

		System.out.println("\n6. Iterator를 활용한 출력(참조 메서드 활용)");
		Iterator<String> it3 = list.iterator();
		it3.forEachRemaining(System.out::println);

		System.out.println("\n7. Collection 정렬");
		System.out.println("정렬 전 - " + list.toString());
		Collections.sort(list);
		System.out.println("정렬 후1 - " + list.toString());
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("정렬 후2 - " + list.toString());
	}

}
