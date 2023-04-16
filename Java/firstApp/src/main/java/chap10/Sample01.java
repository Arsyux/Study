package chap10;

import lombok.Data;
import lombok.RequiredArgsConstructor;

// 제너릭 클래스
// 보편적인 제네릭 타입 매개변수 명명
// E - Element
// K - Key
// N - Number
// T - Type
// V - Value
// 매개변수를 object를 써서 처리할 수도 있지만, 오류가 발생할 수 있으므로 제네릭 타입 사용을 권장함.
@Data
@RequiredArgsConstructor
class GenericTest<T> {
	private T Data;
}

public class Sample01 {

	public static void main(String[] args) {
		GenericTest<Integer> gi = new GenericTest<Integer>();
		gi.setData(1234);
		System.out.println(gi.getData());
		GenericTest<String> gs = new GenericTest<String>();
		gs.setData("Hello!");
		System.out.println(gs.getData());
		// 뒷부분은 <Float>를 <>로 생략하여 표시할 수 있다.
		// Java 7부터 지원함.
		GenericTest<Float> gf = new GenericTest<>();
		gf.setData(3.141592f);
		System.out.println(gf.getData());
		// var를 사용할 경우
		var gv = new GenericTest<Character>();
		gv.setData('A');
		System.out.println(gv.getData());
	}
}
