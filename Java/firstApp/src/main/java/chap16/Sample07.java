package chap16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Sample07 {

	public static void main(String[] args) {
		// 메서드 참조
		// 특정 타입의 임의 개체에 대한 인스턴스 메서드 참조
		// 생성자 참조
		// 메서드 참조의 기본 형태
		// (Object name)::(Method name)
		List<String> list = new ArrayList<String>();
		list.add("Cat");
		list.add("Dog");
		list.add("Tiger");
		list.add("Lion");
		// 메서드 참조 사용
		list.forEach(System.out::println);
		// 람다식으로 구현하면
		// list.forEach( (x) -> System.out.println(x));
		System.out.println();

		// 1. static 메서드 참조
		// 매개변수로 함수형 인터페이스를 사용했기 때문에 값을 갖는 변수를 넘기는게 아니라
		// 메서드 참조 형태의 메서드를 넘거야 한다는 점에 유의해야함
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		list2.forEach(Writer::doWrite);
		// 함수형 인터페이스를 활용하여 직접 static 메서드를 참조하는 코드를 작성
		Function<String, String> helloLambda = (name) -> HelloTo.hello(name);
		Function<String, String> helloStatic = HelloTo::hello;
		
		System.out.println(helloLambda.apply("A"));
		System.out.println(helloStatic.apply("B"));
		System.out.println();

		// 2. 특정 개체의 인스턴스 메서드 참조
		String greeting = "Hello";
		Consumer<String> consumer = System.out::println; // static 메서드 참조
		consumer.accept(greeting);
		
		writeString(greeting::toString); // 인스턴스 메서드 참조
	}

	public static void writeString(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}

class Writer {
	public static void doWrite(Object msg) {
		System.out.println(msg);
	}
}

class HelloTo {
	public static String hello(String name) {
		return "Hello, " + name;
	}
}
