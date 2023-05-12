package chap17_Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample10_IntermediateOperations {

	public static void main(String[] args) {
		// 중간 연산 (Intermediate operations)
		// map()
		// 스트림 요소 하나하나에 연산한 결과를 그대로 반환할 경우에 사용
		List<Integer> list1 = IntStream.rangeClosed(1, 10).map(x -> x * 2).boxed().collect(Collectors.toList());
		System.out.println(list1);

		// flatMap()
		// 여러 개의 Stream을 모두 합쳐서 하나의 스트림으로 반환
		String[] str1 = { "A", "B", "C" };
		String[] str2 = { "D", "E" };

		// 2개의 String 배열을 스트림으로 만듬
		Stream<String[]> strm1 = Stream.of(str1, str2);

		// flatMap()메서드를 통해서 2개의 요소를 1개의 요소로 합치게 됨
		// collect()메서드를 이용해서 List로 반환함
		List<String> list2 = strm1.flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
		System.out.println(list2);

		// mapToObj()
		// 스트림 요소는 연산하는 과정에서 자료형을 변경해야 할 경우가 있음.
		// 이때 Stream<T>를 사용할 경우 자료형을 변경하고자 할 때 사용하는 메서드
		// collect()메서드를 이용해서 홀수와 짝수를 구분하여 Map의 형태로 반환하는 예제 코드임
		// mapToLong(x -> x)는 LongStream 자료형으로 중간 연산을 함.
		// Map의 형태로 반환하기 위해서 boxing(특정 자료형으로 형 변환)을 함.
		Map<Boolean, List<Long>> m1 = IntStream.range(1, 10).mapToLong(x -> x).boxed()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(m1);
		// 똑같은 코드인데 mapToObj()메서드를 사용했으며
		// 인자로 Long::valueOf를 사용하였음.
		// 기존 교재의 내용은 Long::new이지만, version 9부터 deprecated되었으므로
		// 생성자를 생성하는 것이 아닌 반환하는 valueOf메서드를 사용하였음.
		Map<Boolean, List<Long>> m2 = IntStream.range(1, 10).mapToObj(Long::valueOf)
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(m2);

		// filter()
		// 원하는 데이터만 필터링해서 요소를 제어할 경우에 사용
		List<Integer> odd = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> even = Arrays.asList(2, 4, 6, 8, 10);

		// 2개의 배열을 스트림으로 합친 후 3의 배수를 얻음
		List<Integer> listInteger = Stream.of(odd, even).flatMap(List::stream).filter(i -> i % 3 == 0)
				.collect(Collectors.toList());
		System.out.println(listInteger);
		System.out.println();

		// 'ED'가 포함된 단어를 찾는 예제
		List<String> strList = Arrays.asList("RED", "bed", "Bad", "Rad");
		Predicate<String> condition1 = x -> 0 < x.toUpperCase().indexOf("ED");
		strList.stream().filter(condition1).forEach(System.out::println);
		System.out.println();
		// 'ED'가 포함되지 않은 단어
		Predicate<String> condition2 = Predicate.not(condition1);
		strList.stream().filter(condition2).forEach(System.out::println);

		// sorted()
		// 정렬하는 기능
		List<Integer> sortedList = Stream.of(odd, even).flatMap(List::stream).sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		// 역정렬
		List<Integer> reverseSortList = Stream.of(odd, even).flatMap(List::stream).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(reverseSortList);
		// 멤버 변수가 여러개 있을 경우 어떤 멤버 변수를 기준으로 정렬할지 지정
		List<UserInfo> userInfoList = Arrays.asList(new UserInfo(3, "A"), new UserInfo(2, "C"), new UserInfo(1, "B"));
		// 이름순으로 정렬
		System.out.println(userInfoList.stream().sorted((x, y) -> x.getName().compareTo(y.getName()))
				.collect(Collectors.toList()));
		// 번호 순으로 정렬
		System.out.println(userInfoList.stream().sorted((x, y) -> x.getNo() - y.getNo()).collect(Collectors.toList()));
		// compareTo()메서드를 override하여 이름 역정렬을 기본으로 설정하여 출력
		List<UserInfo2> userInfoList2 = Arrays.asList(new UserInfo2(3, "A"), new UserInfo2(2, "C"),
				new UserInfo2(1, "B"));
		System.out.println(userInfoList2.stream().sorted().collect(Collectors.toList()));

		// distinct()
		List<Integer> listInteger2 = Arrays.asList(1, 1, 3, 4, 5, 6, 6, 7);
		System.out.println(listInteger2.stream().distinct().collect(Collectors.toList()));

		// peek()
		// 중간 연산중에 중간에 처리된 요소의 값을 확인하고 싶을 때 peek() 메서드로 확인할 수 있음
		System.out.println(Stream.of("mouse", "cow", "horse", "monkey").peek(x -> System.out.println("처리할 요소 : " + x))
				.map(String::toUpperCase).peek(x -> System.out.println("처리된 요소 : " + x)).collect(Collectors.toList()));

		// limit()와 skip()
		// 스트림의 모든 요소를 사용하는 게 아니라 일부는 제한하고 싶을 때 사용하는 메서드
		// limit() 메서드는 스트림 요소의 처음부터 몇 개 까지만 처리할 때 사용
		// skip()메서드는 처음 몇개는 건너뛰고 이후의 요소부터 처리할 때 사용
		// 선착순 3명
		System.out.println(Stream.of("A", "C", "D", "E", "F", "Z").limit(3).collect(Collectors.toList()));
		// 총 7경기 중에 앞 2경기는 연습 경기
		Map<String, Long> info = Stream.of("패", "승", "패", "승", "승", "승", "패").skip(2)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(info);

		// generate()
		// 임의의 값을 얻는 메서드
		System.out.println(Stream.generate(Math::random).map(n -> (n * 9) + 1).map(Math::round).limit(10).sorted()
				.collect(Collectors.toList()));
		// 랜덤 키값을 얻고자 할 때 UUID를 사용할 수 있음
		Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);
	}

}

@Data
@AllArgsConstructor
class UserInfo {
	private int no;
	private String name;
}

@Data
@AllArgsConstructor
class UserInfo2 implements Comparable<UserInfo2> {
	private int no;
	private String name;

	/**
	 * 기본 정렬을 이름 역정렬로 정의함
	 */
	@Override
	public int compareTo(UserInfo2 o) {
		return o.getName().compareTo(this.getName());
	}
	// 순 정렬
	// @Override
	// public int compareTo(UserInfo2 o) {
	// return this.getName().compareTo(o.getName());
	// }
}