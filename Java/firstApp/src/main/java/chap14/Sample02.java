package chap14;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// @Target
// 애너테이션을 적용할 수 있는 대상을 지정하는 애너테이션임.
@Retention(RUNTIME)
@Target(TYPE)
@interface Anno04 {
	// 1. TYPE
	// TYPE은 Class나 interface, @interface, enum에 적용할 수 있음.
	// 이외의 위치인 메서드명이나 변수명 등에 적용하면 에러 발생
}

@Target(FIELD)
@interface Anno05 {
	// 2. FIELD
	// FIELD는 변수나 enum 요소를 변수로 정의할때 사용할 수 있는 애너테이션임.

}

@Target(METHOD)
@interface Anno06 {
	// 3. METHOD
	// 메서드명에 적용하는 애네테이션
}

@Target(PARAMETER)
@interface Anno07 {
	// 4. PARAMETER
	// 메서드의 파라미터에 적용하도록 대상을 제한함
}

@Target(CONSTRUCTOR)
@interface Anno08 {
	// 5. CONSTRUCTOR
	// 생성자에만 애너테이션을 적용하도록 대상을 제한함
}

@Target(LOCAL_VARIABLE)
@interface Anno09 {
	// 6. LOCAL_VARIABLE
	// 지역 변수에만 사용할 수 있도록 대상을 제한함.
}

@Target(ANNOTATION_TYPE)
@interface Anno10 {
	// 7. ANNOTAION_TYPE
	// ANNOTATION_TYPE은 @interface를 통해서 애너테이션을 만드는 애너테이션을 정의할 때 사용하는 요소임.
	// @Target도 ANNOTATION_TYPE 애너테이션이 되어있음.
}

@Anno10
@interface Anno11 {

}

@Target(PACKAGE)
@interface Anno12 {
	// 8. PACKAGE
	// PACAKGE는 package-info.java 파일의 상단에 위치한 패키지에 적용할 때 사용함.
}

@Target(TYPE_PARAMETER)
@interface Anno13 {
	// 9. TYPE_PARAMETER
	// TYPE_PARAMETER는 제네릭 매개변수 타입 선언시에 사용하는 요소임.
}

@Target(TYPE_USE)
@interface Anno14 {
	// 10. TYPE_USE
	// TYPE_USE는 제네릭 타입을 사용할때의 요소임.
}

enum Color1 {
	RED, BLUE, ORANGE;
}

class annoTest<@Anno13 T> {

}

public class Sample02 {

	@Anno05
	private String test;

	@Anno05
	private Color1 color = Color1.RED;

	@Anno08
	public Sample02() {
	}

	public static void main(String[] args) {
		annoTest<@Anno14 String> annoStr = new annoTest<>();
		
	}

	@Anno06
	public String testMethod(@Anno07 String str) {
		@Anno09
		String str1 = str;
		return str1;
	}

}
