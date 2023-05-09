package chap16;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Sample06 {

	public static void main(String[] args) {
		// Function은 매개변수와 반환 자료형을 각각 정의
		Function<String, String> sourceFile = p -> p + ".java";

		// UnaryOperator는 매개변수와 반환 자료형을 하나로 정의
		// 람다식에 String으로 매개변수를 제한하였음.
		UnaryOperator<String> classFile = (String p) -> p + ".class";

		System.out.println(sourceFile.apply("Sample06"));
		System.out.println(classFile.apply("Sample06"));
		
		// 매개변수가 2개인 함수형 인터페이스
		// 앞에 Bi를 붙이면됨
		// 다만 UnarPerator 함수형 인터페이스는 BinaryOperator 함수형 인터페이스를 사용함
	}

}
