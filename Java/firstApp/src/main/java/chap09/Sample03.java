package chap09;

// abstract 생략 가능
abstract interface ICompute {
	// 인터페이스의 멤버 변수는 'static final'로 컴파일 됨.
	// 즉, 값의 변경이 불가능
	float pyung = 3.3f;

	// abstract float compute(int area); 추상 메서드로 처리됨.
	float compute(int area);

	// 새로운 메서드 추가. implements된 모든 클래스는 이 메서드를 구현해야함.
	float toPyung(int area);
}

class Apartment implements ICompute {

	@Override
	public float compute(int area) {
		return area * pyung;
	}

	@Override
	public float toPyung(int area) {
		return area / pyung;
	}
}

abstract interface IExcute {
	float pyung = 3.3f;

	float compute(int area);

	// 디폴트 메서드
	// Implements한 클래스에서 구현하지 않아도 됨.
	// 추상 클래스에서 정의한 일반 메서드와 똑같은 결과를 얻을 수 있음.
	// 디폴트 메서드의 default는 접근제어자가 아님.
	// 즉 (default) default float toPyung(float area) { ... }임.
	default float toPyung(float area) {
		return area / pyung;
	}

}

class Villa implements IExcute {

	@Override
	public float compute(int area) {
		return area * pyung;
	}
}

public class Sample03 {

	public static void main(String[] args) {
		ICompute a = new Apartment();
		float area = a.compute(30);
		System.out.println(area);
		float pyung = a.toPyung(99);
		System.out.println(pyung);
	}
}
