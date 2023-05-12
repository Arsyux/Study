package chap14_Annotation;

import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.util.Arrays;

//메타 애너테이션 (Meta-annotations)
//메타 애너테이션은 사용자가 직접 만드는 애너테이션으로 인터페이스를 만들듯이 하되 인터페이스 앞에 '@'문자를 넣어주어야함.
// @Retention
// 애너테이션이 유지되는 범위를 지정할 때 사용함.
// 범위는 소스 코드를 작성할 때, 컴파일 시, 런타임 시를 말하며 RetentionPolicy 열거형 클래스에 다음과 같이 3가지로 구성되어있음.
@Retention(SOURCE)
@interface Anno01 {
	// 1. SOURCE
	// 소스 파일에만 존재하며 컴파일된 클래스 파일에는 전혀 영향을 주지 않음. 다시말해서 프로그래머가 개발할 때 가이드 용도로 주로 사용하게됨.
	// 주로 내장형 애너테이션중에 @Override, @SuppressWarnings을 사용함.
	// 13라인에서 SOURCE를 사용하기 위해 04라인에서 static을 사용하여 선언해주었음.
	// 단순 Import할 경우에는 @Retention(RetentionPolicy.SOURCE)로 사용하면됨.
	// 두 소스는 Import방식의 차이임.
}

@Retention(CLASS)
@interface Anno02 {
	// 2. CLASS
	// CLASS는 SOURCE와는 다르게 컴파일할 때만 사용되며 컴파일된 이후에는 더이상 애너테이션의 내용을 사용할 수 없게 됨.
	// @Retention을 작성하지 않으면 기본적으로 CLASS로 동작하게됨
}

@Retention(RUNTIME)
@interface Anno03 {
	// 3. RUNTIME
	// CLASS와 동일하게 컴파일할 때 사용되며 컴파일된 이후에도 실행 중에 애너테이션의 정보를 계속해서 사용할 수 있음.
	// 그래서 RetentionPolicy의 요소 중에 CLASS를 제외한 SOURCE와 RUNTIME을 주로 사용하게 됨.
}

@Anno01
public class Sample01_Retention {

	// Retention(SOURCE)로 설정을 하여 어디에 애너테이션을 붙혀도 에러가 발생하지 않음.
	@Anno01
	public void test() { }

	public static void main(String[] args) {
		// CLASS와 RUNTIME 차이
		@Anno02
		class C {
		}

		@Anno03
		class R {
		}
		System.out.println("클래스명 : " + C.class.getName());
		System.out.println("Annotation 수 : " + C.class.getAnnotations().length);
		System.out.println("Annotations : " + Arrays.toString(C.class.getAnnotations()));
		System.out.println();
		System.out.println("클래스명 : " + R.class.getName());
		System.out.println("Annotation 수 : " + R.class.getAnnotations().length);
		System.out.println("Annotations : " + Arrays.toString(R.class.getAnnotations()));
	}

}
