package chap17_Stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

public class Sample04_Stream4 {

	public static void main(String[] args) {
		// 컬렉션 (Collection)
		// Collection은 크게 List 자료형과 Set 자료형으로 분류됨
		// Collection 인터페이스에는 stream() 메서드를 추상 메서드로 정의하고 있기 때문에
		// 꼭 구현되어 있음.
		// 컬렉션에서 스트림을 이용해 출력하는 예제임.
		
		// 1. 배열 생성
		var list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("D");

		var list2 = new HashSet<Integer>();
		list2.add(3);
		list2.add(3);
		list2.add(5);
		list2.add(5);
		list2.add(6);
		list2.add(6);

		// 2. 스트림 생성
		Stream<String> arrStrm1 = list1.stream();
		Stream<Integer> arrStrm2 = list2.stream();

		// 3. 스트림을 이용한 출력
		System.out.println("스트림을 이용한 출력");
		arrStrm1.forEach(System.out::println);
		System.out.println();
		arrStrm2.forEach(System.out::println);
		System.out.println();

		// 4. 컬렉션에서 스트림을 이용한 출력
		System.out.println("컬렉션에서 스트림을 이용한 출력");
		list1.stream().forEach(System.out::println);
		System.out.println();
		list2.stream().forEach(System.out::println);
	}

}
