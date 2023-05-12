package chap17_Stream;

import java.util.stream.Stream;

public class Sample05_Stream5 {

	public static void main(String[] args) {
		try {
			// 비어있는 스트림 (Empty Stream)
			String[] arrStr = null;
			// NullPointerException발생
			// Stream<String> strm = Stream.of(arrStr);
			// strm.forEach(System.out::println);
			// of메서드를 활용하여 Stream으로 변환할때 Stream.empty()로 예외처리
			Stream<Object> strm = Stream.of(arrStr == null ? Stream.empty() : arrStr);
			strm.forEach(System.out::println);
		} catch (NullPointerException e) {
			System.out.println("에러 발생 : " + e.toString());
		}
	}

}
