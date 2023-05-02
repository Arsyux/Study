package chap14;

class SV<T> {

	// @SafeVarargs
	// - 제네릭 타입의 가변 인자 사용으로 어떤 자료형이 몇 개가 어떻게 들어오는지 알 수 없을 때
	// 어떤 유해한 작업이 존재하지 않다고 알림으로써 경고 메시지를 표시하지 않는 애너테이션입니다.
	@SafeVarargs
	public final void safe(T... toAdd) { } // <- 가변 인자

}

public class Sample05 {
	// 내장형 애너테이션
	// @Override
	// @Deprecated
	// @SuppressWarnings
	// @SafeVarargs
	// @FuntionalInterface
	// -> 함수형 인터페이스를 의미함
	
}
