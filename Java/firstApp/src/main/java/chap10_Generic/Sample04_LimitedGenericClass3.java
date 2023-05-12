package chap10_Generic;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Sample04_LimitedGenericClass3 {
	public static void main(String[] args) {
		Student<Double, String> s = new Student<>(1.12, "abc");
		s.printInfo();
		// 제한으로 인해 생성 불가
		// Student1<String, String> s1 = new Student1<>("aaa", "bbb");
		Student1<Double, Integer> s1 = new Student1<>(12.12, 12344);
		s1.printInfo();
	}
}

// 복수의 제네릭
@Getter
@AllArgsConstructor
class Student<G, C> {
	G g;
	C c;

	public void printInfo() {
		System.out.println("Data : " + g + ", " + c);
	}
}

// 숫자만 제한
@Getter
@AllArgsConstructor
class Student1<G extends Number, C extends Number> {
	G g;
	C c;

	public void printInfo() {
		System.out.println("Data : " + g + ", " + c);
	}
}