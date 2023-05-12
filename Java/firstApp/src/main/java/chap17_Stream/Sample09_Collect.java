package chap17_Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Sample09_Collect {

	public static void main(String[] args) {
		// 6. collect()
		// 배열들로 반환할 때 사용 : toList(), toSet(), toCollection(), toMap()
		String[] animals = { "토끼", "호랑이", "고양이", "강아지", "고양이", "고양이" };
		System.out.println("기본 배열 출력");
		System.out.println(Arrays.deepToString(animals));

		System.out.println("List로 변환 후 출력");
		// collect -> 3줄 static 참고
		List<String> ani1 = Arrays.stream(animals).collect(Collectors.toList());
		System.out.println(ani1.toString());
		System.out.println("Set으로 변환 후 출력(중복 제거)");
		Set<String> ani2 = ani1.stream().collect(Collectors.toSet());
		System.out.println(ani2.toString());
		System.out.println("TreeSet으로 변환 후 출력(중복 제거, 정렬)");
		TreeSet<String> ani3 = ani1.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(ani3.toString());
		System.out.println("HashMap으로 변환 후 출력");
		// toMap()메서드는 toMap(keyMapper, valueMapper, mergeFunction)으로 정의 되어있음
		// keyMapper는 Function함수형 인터페이스에서 배운 Function.identity()를 사용하였음.
		// 값이 넘어온 매개 변수의 값을 그대로 출력하게 되어 스트림 요소를 Map의 key값으로 사용하게 됨
		// valueMapper의 값으로는 스트림 요소의 문자 길이를 넣게 되어 Map의 value 값이 됨
		// mergeFunction의 용도는 Map의 경우에는 중복된 key가 있을 수 없음.
		// 이때 mergeFunction이 호출되는데, 여기에서는 이미 존재하는 key의 값을 x1의 인자로 넘기고
		// 중복된 새로운 Map의 value가 x2로 넘어오게 됨.
		// 결국, 같은 key에 문자열 길이를 더하여 반환하게 처리하게 됨.
		// 중복이 없을 경우 toMap(keyMapper, valueMapper)를 사용.
		// 중복이 없다는 보장이 되지 않는다면 위의 메서드로 구현.
		Map<String, Integer> ani4 = ani1.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (x1, x2) -> x1 + x2));
		System.out.println(ani4.toString());

		// 중복이 없는 스트림에서 toMap()을 활용하는 방법
		String[][] level = { { "A", "초급" }, { "B", "중급" }, { "C", "고급" } };
		Map<String, String> map = Arrays.stream(level).collect(Collectors.toMap(x -> x[0], x -> x[1]));
		System.out.println(map.toString());
		// 중복이 있을 경우 IllegalStateException 발생
		try {
			String[][] level2 = { { "A", "초급" }, { "B", "중급" }, { "C", "고급" }, { "C", "고급" } };
			Map<String, String> map2 = Arrays.stream(level2).collect(Collectors.toMap(x -> x[0], x -> x[1]));
			System.out.println(map2.toString());
		} catch (IllegalStateException e) {
			System.out.println("데이터에 중복이 있습니다.\n에러 정보 : " + e);
		}
		// mergeFunction을 구현해주었음.
		String[][] level3 = { { "A", "초급" }, { "B", "중급" }, { "C", "고급" }, { "C", "고급" } };
		Map<String, String> map3 = Arrays.stream(level3)
				.collect(Collectors.toMap(x -> x[0], x -> x[1], (x, y) -> x + ", " + y));
		System.out.println(map3.toString());
		// collectingAndThen(), reverse()
		// collectingAndThen()는 다른 자료형으로 변환하여 변환한 후에 추가 작업을 할 수 있음
		// collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
		// downstream 인자에 toList()나 toSet()등을 하여 배열로 변환시킨 뒤에 finisher 인자에 최종 작업을 추가로 더 할
		// 수 있게 됨.
		// Function은 1개의 매개변수가 있고 반환 자료혀형을 갖고있음.
		// reverse()메서드는 배열을 역정렬하는 기능임
		List<String> locals = Arrays.asList("서울", "대전", "대구", "광주", "부산", "제주");
		// List로 반환되는 컬렉션을 city로 받아서 Collections.reverse() 메서드로 역정렬을 한 뒤에 stream으로 반환하여
		// toList()메서드로 최종 List형으로 반환하게 됨
		List<String> reverseLocals = locals.stream().collect(Collectors.collectingAndThen(Collectors.toList(), city -> {
			Collections.reverse(city);
			return city.stream();
		})).collect(Collectors.toList());
		System.out.println(locals.toString());
		System.out.println(reverseLocals.toString());
		System.out.println();

		// unmodifiableList(), unmodifiableMap(), unmodifiableSet()
		// 해당 메서드는 Collection 클래스를 수정할 수 없는 상태로 반환하게 됨
		List<String> G7 = Stream.of("미국", "영국", "프랑스", "독일", "이탈리아", "캐나다", "일본")
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(G7);
		try {
			G7.add("대한민국");
		} catch (UnsupportedOperationException e) {
			System.out.println("List를 수정할 수 없습니다.\n에러 정보 : " + e);
		}

		// averagingDouble(), averagingInt(), averagingLong()
		List<Integer> list1 = Arrays.asList(100, 100, 61, 85, 91);
		System.out.println("평균 : " + list1.stream().collect(Collectors.averagingInt(i -> i)));
		List<Double> list2 = Arrays.asList(100.0, 100.8, 61.7, 85.5, 91.9);
		System.out.println("평균 : " + list2.stream().collect(Collectors.averagingDouble(i -> i)));
		List<Long> list3 = Arrays.asList(100L, 100L, 61L, 85L, 91L);
		System.out.println("평균 : " + list3.stream().collect(Collectors.averagingLong(i -> i)));

		List<Score> scores = Arrays.asList(new Score("A", 61, 71, 81), new Score("B", 62, 72, 82),
				new Score("C", 100, 100, 61));
		double averageMat = scores.stream().collect(Collectors.averagingInt(Score::getMat));
		System.out.println("수학 평균 : " + averageMat);

		// counting()
		// 스트림 요소 하나하나를 세어 최종 스트림 요소의 수를 반환함
		// 게시글을 작성하고 최종 글이 위로 오게 역정렬한 뒤에 마지막에 글의 수를 출력해보는 예제
		List<FreeBoard> list5 = Arrays.asList(new FreeBoard(1, "가입인사", "Hello!"),
				new FreeBoard(2, "가입인사", "Nice to meet you"), new FreeBoard(3, "질문 있습니다.", "May I ask a question?"));
		List<FreeBoard> reverseList5 = list5.stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), contents -> {
					Collections.reverse(contents);
					return contents.stream();
				})).collect(Collectors.toList());
		long cnt = list5.stream().collect(Collectors.counting());
		reverseList5.stream().forEach(System.out::println);
		System.out.println(cnt);

		// maxBy(), minBy()
		// 요소 중 제일 큰 값과 작은 값을 Optinal<T>객체로 반환 받는 메서드
		// Comparator.comparing() 메서드를 이용해서 비교한 결과 중 최대/최소인 요소를 반환
		System.out.println("국어 점수가 최저인 학생");
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getKor))).ifPresent(System.out::println);
		System.out.println("영어 점수가 최고인 학생");
		scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getEng))).ifPresent(System.out::println);

		// joining()
		// joining() 메서는 스트림 요소들을 하나로 조합하는 메서드임
		List<String> list6 = Arrays.asList("python", "C++", "JAVA");
		// 단순 조합
		String s1 = list6.stream().collect(Collectors.joining());
		System.out.println(s1);
		// 요소와 요소를 구분자로 구분
		String s2 = list6.stream().collect(Collectors.joining(", "));
		System.out.println(s2);
		// 구분자, 접두사, 접미사
		String s3 = list6.stream().collect(Collectors.joining(" ,", "프로그래밍 언어에는 ", " 등이 있습니다."));
		System.out.println(s3);

		// reducing()
		// reducing() 메서드는 IntStream에서 학습했던 reduce() 메서드 사용법과 같음.
		long sum1 = IntStream.rangeClosed(1, 10).reduce(0, Integer::sum);
		System.out.println(sum1);
		// boxed()메서드로 IntStream을 Stream<Integer>형태로 변경하였음.
		long sum2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.reducing(0, Integer::sum));
		System.out.println(sum2);

		// groupingBy()
		// 배열의 요소들을 특정한 값을 기준으로 집계를 한다거나 분류를 할 때 주로 사용하는 방법
		// 수학 점수를 기준으로 A,B,C,D,F 학점으로 분류
		// Stream으로 넘어오는 Score의 getMat() 메서드로 수학 점수를 받아서 학점을 기준으로 그룹핑하여
		// 학점의 대상이 되는 이름을 출력함
		Map<String, List<Score>> result = scores.stream().collect(Collectors.groupingBy(s -> {
			String grade = "F";
			int score = s.getMat();
			if (score > 90) {
				grade = "A";
			} else if (score > 80) {
				grade = "B";
			} else if (score > 70) {
				grade = "C";
			} else if (score > 60) {
				grade = "D";
			}
			return grade;
		}));
		result.keySet().forEach(key -> {
			System.out.printf("수학 %s 학점\n", key);
			List<Score> score = result.get(key);
			score.stream().forEach(s -> System.out.println(s.getName()));
		});
		List<String> list7 = Arrays.asList("출근", "지각", "지각", "출근", "출근", "출근", "지각", "출근", "지각", "출근", "지각", "출근", "지각",
				"결근");
		// 186라인에서 첫번째 인자는 그룹핑의 기준이 되는 배열의 값을 정의함.
		// Function.identity()는 넘겨받은 값을 그대로 반환하는 기능을 갖고 있으므로 배열의 요소가 넘어오게 되며 두 번재 인자는
		// 요소의 수를 나타냄
		Map<String, Long> info = list7.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(info);

		// partitioningBy()
		// groupBy()메서드와 비슷하지만 차이는 Fuction함수형 인터페이스와 Predicate함수형 인터페이스를 인자로 사용하는 차이가 있음
		// 수학 80점 이상인 사람과 그렇지 않은 사람을 구분
		Map<Boolean, List<Score>> result2 = scores.stream().collect(Collectors.partitioningBy(s -> {
			return (s.getMat() > 80) ? true : false;
		}));
		System.out.println("수학 80이상인 학생");
		List<Score> list8 = result2.get(true);
		list8.stream().forEach(x -> System.out.println(x.getName()));
		// 수학 80점 이상인 사람과 그렇지 않은 사람은 각각 몇명인지?
		Map<Boolean, Long> count = scores.stream().collect(Collectors.partitioningBy(s -> {
			return (s.getMat() > 80) ? true : false;
		}, Collectors.counting()));
		System.out.println("80점 이상인 학생의 수 : " + count.get(true));
		System.out.println("80점 미만인 학생의 수 : " + count.get(false));

		// distinct()
		// 중복제거
		List<String> ani5 = Arrays.stream(animals).distinct().collect(Collectors.toList());
		System.out.println(ani5);

		// count()
		// 개수
		System.out.println(IntStream.rangeClosed(12, 125).count());
		// counting()썼을 때
		System.out.println(IntStream.rangeClosed(12, 125).boxed().collect(Collectors.counting()));

		// min(), max()
		// 최소, 최대
		System.out.println(IntStream.rangeClosed(333, 1553).boxed().min(Integer::compare).get());
		System.out.println(IntStream.rangeClosed(333, 1553).boxed().max(Integer::compare).get());

		// sum()
		// 합
		System.out.println(IntStream.rangeClosed(1, 10).sum());

		// average()
		// 평균
		System.out.println(IntStream.rangeClosed(1, 10).average().getAsDouble());

		// anyMatch(), allMatch(), noneMatch()
		// 이 세 메서드는 Predicate 함수형 인터페이스를 사용하여 이 결과의 여부에 따라서 true와 false를 반환
		// Predicate 함수형 인터페이스는 1개의 매개변수와 boolean 자료형의 반환으로 구성되어 있기 때문에
		// 람다식으로 조건식을 넣어서 boolean으로 결과가 나올 수 있도록 구현하면 됨
		List<Score> scores2 = Arrays.asList(new Score("A", 61, 31, 31), new Score("B", 62, 32, 82),
				new Score("C", 100, 30, 31));
		// 하나라도 참이면 true
		boolean b1 = scores2.stream().anyMatch(x -> x.getMat() > 39);
		System.out.println("수학 40점을 넘는 사람이 있는지? " + b1);
		// 모두가 참이면 true
		boolean b2 = scores2.stream().allMatch(x -> x.getKor() > 39);
		System.out.println("모든 학생이 국어 40점을 넘었는지? " + b2);
		// 모두가 거짓이면 true
		boolean b3 = scores2.stream().noneMatch(x -> x.getEng() > 39);
		System.out.println("영어가 모두 40점을 안넘는지? " + b3);

		// findAny(), findFirst()
		// findAny()는 스트림 요소 중에 조건에 맞는 첫 번째 요소를 찾음.
		// findFirst()는 첫번째 요소를 찾음

		List<Integer> list9 = Arrays.asList(4, 6, 2, 8, 10);
		// 요소들 중에 제일 먼저 찾은 요소를 얻는다.
		list9.stream().findAny().ifPresent(System.out::println);
		// 요소들 중에 첫 요소를 찾아서 얻는다.
		list9.stream().findFirst().ifPresent(System.out::println);
		System.out.println();
		list9.stream().filter(x -> x > 2).findAny().ifPresent(System.out::println);
		// 병렬로 처리될 경우 값이 달라질 수 있음
		list9.parallelStream().filter(x -> x > 2).findAny().ifPresent(System.out::println);
		list9.stream().filter(x -> x>2).findFirst().ifPresent(System.out::println);
		list9.parallelStream().filter(x -> x > 2).findFirst().ifPresent(System.out::println);
	}

}

@Data
@RequiredArgsConstructor
class Score {
	private final String name;
	private final int kor;
	private final int eng;
	private final int mat;
	private String msg;
}

@Data
@AllArgsConstructor
class FreeBoard {
	private int no;
	private String title;
	private String contents;
}