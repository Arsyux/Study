package chap17;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample08 {

	public static void main(String[] args) {
		// 스트림 연산 (Stream Operations)
		// 스트림을 생성한 뒤에 중간에 스트림 내부 반복중에 연산하는 작업을 '중간 연산'이라고 하며 '최종 연산'을 진행해야지만
		// 중간 연산이 실행되고 최종 연산을 실행하게 됨
		// 최종 연산 (Terminal Operations)
		// 최종 연산을 실행하게 되는 시점에 중간 연산을 시작하고 중간 연산이 모두 끝나면 최종 연산을 실행하게 됨
		// 이렇게 작업한 결과물은 원본을 수정하지 않으며 스트립 작업은 일회성으로 재사용이 안됨

		// 1. toArray()
		// 스트림을 다시 배열로 반환하는 메서드임.
		// Stream을 활용하여 1부터 100까지의 배열 생성
		int[] numbers = IntStream.rangeClosed(1, 100).toArray();
		// Stream을 활용하여 배열 출력
		Arrays.stream(numbers).forEach(System.out::println);
		System.out.println();

		// 2. forEach()
		// 내부 반복을 실행하는 메서드
		// for문과 비슷하며 각 배열의 요소를 처음부터 끝까지 반복 처리하게 됨
		Stream.of("A", "B", "C").forEach(name -> System.out.printf("%s ", name));
		System.out.println();
		Arrays.asList("A", "B", "C").stream().forEach(name -> System.out.printf("%s ", name));
		System.out.println();

		// 3. forEachOrdered()
		// 병렬 스트림을 이용하여 forEach() 메서드로 출력하게 되면 순서를 보장할 수 없음
		// 이 때 순서를 보장받기 위한 방법으로 forEachOrdered() 메서드를 사용
		System.out.println("직렬 스트림 forEach로 출력");
		IntStream.rangeClosed(65, 69).forEach(x -> System.out.println((char) x));
		System.out.println("병렬 스트림 forEach()로 출력");
		IntStream.rangeClosed(65, 69).parallel().forEach(x -> System.out.println((char) x));
		System.out.println("병렬 스트림 forEachOrdered()로 출력");
		IntStream.rangeClosed(65, 69).parallel().forEachOrdered(x -> System.out.println((char) x));
		System.out.println();

		// 4. reduce()
		// 스트림 요소를 합이나 최댓값 등을 구할 때 유용하게 사용할 수 있음.
		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			sum1 += i;
		}
		System.out.println("for문 : " + sum1);
		// 초기값을 1(Index)로하고 10까지의 수를 반복하여 누적합을 구함.
		int sum2 = IntStream.rangeClosed(1, 10).reduce(0, Integer::sum);
		System.out.println("reduce 메서드 참조 : " + sum2);
		int sum3 = IntStream.rangeClosed(1, 10).reduce(0, (x, y) -> x + y);
		System.out.println("reduce Lambda1 : " + sum3);
		int sum4 = IntStream.rangeClosed(1, 10).reduce(0, (x, y) -> {
			return x + y;
		});
		System.out.println("reduce Lambda2 : " + sum4);
		OptionalInt sum5 = OptionalInt.empty();
		if (sum5.isEmpty()) {
			System.out.println("sum5의 값이 비어있습니다.");
		}
		// OptionalInt는 of()메서드를 사용해 값을 넣음.
		sum5 = OptionalInt.of(6);
		if (sum5.isPresent()) {
			System.out.println("getAsInt() : " + sum5.getAsInt());
			System.out.println(sum5);
		} else {
			System.out.println("sum5의 값이 비어있습니다.");
		}

		// 5. ifPresent()
		// 값이 있을 경우에는 true를 반환하고 없으면 false를 반환함.
		IntStream.rangeClosed(1, 10).reduce(Integer::sum).ifPresent(System.out::println);
		System.out.println();
	}

}
