package chap16;

import java.util.function.Supplier;

public class Sample02 {

	public static void main(String[] args) {
		// 함수형 인터페이스 API
		/*
		Runnable          void    run()           없음
		Supplier            T     get()           없음
		Consumer          void    accept(T t)     1개
		Function<T,R>       R     apply(T t)      1개
		Predicate        boolean  test(T t)       1개
		UnaryOperator       T     apply(T t)      1개
		BiConsumer<T,U>   void    accept(T t,U u) 2개
		BiFunction<T,U,R>   R     apply(T t,U u)  2개
		BiPredicate<T,U> boolean  test(T t,U u)   2개
		BinaryOperator      T     apply(T t,U u)  2개
		*/
		// 매개변수가 없는 함수형 인터페이스
		// Runnable - 매개변수도 없고 반환할 자료형도 없이 내부적으로 처리만 할 경우에 사용
		Runnable r = ()->{ System.out.println("Runnable"); }; 
		r.run();
		// Supplier는 반환할 자료형을 제네릭으로 자료형을 선언한 후에 실행문에 제네릭으로 선언한 자료형을 반환할 경우에 사용
		Supplier<String> s = () -> "Supplier";
		System.out.println(s.get());
		// return문을 넣어서 구현
		Supplier<String> s2 = () -> {
			return "Supplier2";
		};
		System.out.println(s2.get());		
	}

}


