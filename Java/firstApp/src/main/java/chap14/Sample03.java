package chap14;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;

@Documented
@interface Anno15 {
	// Documented이 정의된 애너테이션을 사용하게 되면 애너테이션 정보가 Javadoc으로 작성된 문서에 포함되게 합니다.
}

@Inherited
@interface Anno16 {
	// Inherited이 삽입된 애너테이션이 있다면 상속받는 클래스 정보와 함께 조상 클래스가 갖고 있는 애너테이션도 함께 상속받게 됨.
}

@Inherited
@Target(TYPE)
@Retention(RUNTIME)
@interface t1 {
	
}

@t1
@interface t2 {
	
}

public class Sample03 {
	
	public static void main(String[] args) {
		// 애너테이션 함께 상속
		System.out.println(Arrays.toString(t2.class.getAnnotations()));
	}
	
}
