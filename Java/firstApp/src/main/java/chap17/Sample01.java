package chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample01 {

	public static void main(String[] args) {
		// 스트림 (Stream)
		// 람다식으로 데이터를 출력할 때, 중복된 값을 제거하려면 해당 내용을 구현해야함.
		var list = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 4);
		System.out.println(list.toString());

		System.out.println("HashSet을 활용한 중복제거");
		var<Integer> list2 = new ArrayList<>(new HashSet<Integer>(list));
		list2.forEach(System.out::print);
		System.out.println();
		
		System.out.println("Stream을 활용한 중복제거");
		list.stream().distinct().forEach(System.out::print);
		System.out.println();
		
		// 스트림의 생성
		// 배열은 반복되는 자료형의 연속이며, 내부적으로 반복하며 연산하지 않음.
		// 그럼 내부적으로 반복처리를 하고자 하려면 스트림을 생성해야하는데
		// 이렇게 스트림으로 생성된 형태를 스트림 파이프라인(stream pipeline)이라고함.
		// 스트림의 생성은 각배열의 형태에 따라서 생성하는 방법이 다름.
		
		// 스트림은 가장 기본이 되는 BaseStream 인터페이스로 구현되어 있으며
		// 객체 자료형을 활용할 때는 Stream<T> 인터페이스를 활용해서 구현함.
		// 숫자 자료형은 IntStream, DoubleStream, LongStream을 사용함.
		
		// 배열
		// 배열을 Stream과 Arrays객체의 스트림으로 변환하는 메서드를 이용하여 변환
		// 1. 배열
		String[] str = {"A", "B", "C"};
		int[] intArr = {3, 6, 9};
		double[] doubleArr = { 3.1415926, 1.414, 2.14 };
		
		// 2. 스트림 생성
		Stream<String> strStm = Arrays.stream(str);
		IntStream intStm = Arrays.stream(intArr);
		DoubleStream doubleStm = Arrays.stream(doubleArr);
		
		// 3. 출력
		strStm.forEach(System.out::println);
		intStm.forEach(System.out::println);
		doubleStm.forEach(System.out::println);
	}

}
