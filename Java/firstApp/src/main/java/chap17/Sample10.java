package chap17;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample10 {

	public static void main(String[] args) {
		// 중간 연산 (Intermediate operations)
		// map()
		// 스트림 요소 하나하나에 연산한 결과를 그대로 반환할 경우에 사용
		List<Integer> list = IntStream.rangeClosed(1, 10).map(x -> x*2).boxed().collect(Collectors.toList());
		System.out.println(list);
	}

}
