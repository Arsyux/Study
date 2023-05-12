package chap16_LambdaExpression;

import java.util.function.Function;

public class Sample03_Lambda3 {

	public static void main(String[] args) {
		// 입력된 문자열을 숫자로 변환
		Function<String, Integer> work = s -> {
			System.out.println("- 입력된 문자열을 숫자로 변환합니다.");
			return Integer.parseInt(s);
		};

		// 입력된 숫자를 문자열로 변환
		Function<Integer, String> after = i -> {
			System.out.println("- 입력된 숫자를 문자열로 변경합니다.");
			return i.toString();
		};

		System.out.println("문자열 '123'을..");

		// andThen()
		// Function 함수형 인터페이스는 반환값이 있기 때문에 현재의 람다식이 처리된 결과를 다음 람다식(after)으로 인자가 넘어가게 됨.
		// work라는 람다식으로 문자열을 숫자로 변환하는 함수를 만들고 후처리로 숫자를 문자열로 변경하는 함수를 만들었음.
		// andThen()메서드로 두 함수를 조립한 후에 apply() 메서드에 숫자 값을 갖는 문자열 '123'을 넣었음.
		// work함수에서 문자열 '123'을 숫자 123으로 변환한 후에 이 결과물을 after 함수에서 다시 숫자 123을 '123'으로 변경함.
		// 이후 변경한 '123'이 문자열이 맞는지 istanceof로 자료형이 맞는지 비교
		if (work.andThen(after).apply("123") instanceof String) {
			System.out.println("String 입니다.");
		} else {
			System.out.println("String이 아닙니다.");
		}
		System.out.println();
		
		// identity()
		// 이 메서드는 static으로 실행되는 메서드임.
		// 람다식에서 사용하기 보다는 Stream에서 넘어온 값을 이용하여 처리할 때 넘어온 값을 얻을 경우에 사용하게 됨.
		// 매개변수가 한 개일 경우, 반환 자료형이 없을 때는 Consumer 함수형 인터페이스를 사용
		// 반환 자료형이 있을 때는 Function 함수형 인터페이스를 사용하면 됨.
		Function<Integer, Integer> fun = Function.identity();
		System.out.println(fun.apply(100));
		
		
	}

}
