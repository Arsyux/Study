package chap11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Spliterator;

public class Sample07 {

	public static void main(String[] args) {
		// Set은 순차적이지 않은 자료와 중복을 허용하지 않음.
		// HashSet과 TreeSet이 있음.
		// add() - 똑같은 요소가 없으면 세트에 추가
		// clear() - 세트에서 모든 요소를 제거
		// clone() - HashSet인스턴스의 단순 복사본을 반환
		// contains() - 지정된 요소가 존재하면 true, 없으면 false
		// isEmpty() - 세트에 요소가 없는 경우 true를 반환
		// iterator() - iterator 객체로 반환
		// remove() - 인자로 들어온 요소와 일치하는 요소 제거
		// size() - 세트의 요소 수 반환
		// spliterator() - Iterator()와 비슷하며 병렬 작업에 특화됨
		
		// ArrayList
		var list = new ArrayList<String>();
		list.add("dog");
		list.add("dog");
		list.add("cat");
		list.add("cat");
		list.add("lion");
		list.add("lion");
		System.out.println("<< ArrayList >>");
		System.out.println(list);

		// HashSet
		var hs = new HashSet<String>();
		hs.addAll(list);
		System.out.println("\n<< HashSet >>");
		System.out.println(hs);

		// Spliterator
		System.out.println("\n<< Spliterator >>");
		Spliterator<String> namesSpliterator = hs.spliterator();
		namesSpliterator.forEachRemaining(System.out::println);
	}

}
