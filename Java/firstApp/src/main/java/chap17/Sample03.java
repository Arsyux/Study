package chap17;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sample03 {

	public static void main(String[] args) {
		String[] str1 = { "A", "B", "C" };
		String[] str2 = { "a", "b" };

		// Stream.of()를 사용하여 Stream을 생성
		Stream<String[]> strm1 = Stream.of(str1, str2);
		System.out.println("Stream.of(str1, str2)");
		// String[]의 형태로 출력
		Stream.of(str1, str2).forEach(x -> System.out.println(Arrays.deepToString(x)));
		System.out.println();

		System.out.println("strm1.flatMap(Arrays::stream)");
		// flatMap()메서드로 인하여 모든 요소를 단일 요소로 스트림을 반환할 수 있음.
		// Arrays::stream은 Arrays.toString() 메서드와 같이 사용하던 방식으로
		// static으로 구현된 메서드임.
		// 모든 배열을 스트림으로 변환하는 메서드이며 메서드 참조 형태로 작성된 것.
		Stream<String> strm2 = strm1.flatMap(Arrays::stream);
		strm2.forEach(System.out::println);
	}

}
