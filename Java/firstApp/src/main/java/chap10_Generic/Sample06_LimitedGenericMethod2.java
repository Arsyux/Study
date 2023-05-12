package chap10_Generic;

public class Sample06_LimitedGenericMethod2 {
	public static void main(String[] args) {
		NumberBox nb = new NumberBox();
		nb.setNumber(123123);
		nb.setNumber(3.1234);
		// 오류
		//nb.setNumber("1212");
	}
}

class NumberBox {
	// 제한된 자료형의 제네릭 메서스
	public <E extends Number> void setNumber(E e) {
		System.out.printf("입력된 값: %s\n", e.toString());
	}
}