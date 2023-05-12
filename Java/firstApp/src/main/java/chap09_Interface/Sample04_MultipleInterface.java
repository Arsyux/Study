package chap09_Interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 다수의 인터페이스를 활용한 인터페이스 구현
interface Student {
	void study();
}

interface Teacher {
	void teach();
}

// 학생
class P1 implements Student {
	@Override
	public void study() {
		System.out.println("P1이 공부한다.");
	}
}

// 선생님
class P2 implements Teacher {
	@Override
	public void teach() {
		System.out.println("P2가 가르친다.");
	}
}

// 학생, 선생님
class P3 implements Student, Teacher {
	@Override
	public void study() {
		System.out.println("P3이 공부한다.");
	}

	@Override
	public void teach() {
		System.out.println("P3이 가르친다.");
	}
}

public class Sample04_MultipleInterface {

	public static void main(String[] args) {
		// 다수의 interface를 활용한 클래스 구현
		P1 p1 = new P1();
		p1.study();
		P2 p2 = new P2();
		p2.teach();
		P3 p3 = new P3();
		p3.study();
		p3.teach();

		// 일반적인 List의 사용
		List<String> list1 = new ArrayList<String>();
		// 순서가 필요한 배열
		List<String> list2 = new LinkedList<String>();
		// 사용법은 똑같지만 내부적으로 처리되는 방식은 다름.
		list1.add("Apple");
		list2.add("Apple");
		// 코드 재사용의 용도가 아니라면,
		// 다형성처럼 똑같은 자료형의 메서드를 정의해서 구현할대는 추상클래스보다는 인터페이스를 권장함.
	}

}
