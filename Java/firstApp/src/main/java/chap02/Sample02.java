package chap02;

public class Sample02 {

	public static void main(String[] args) {
		// 비기본자료형 (Non-Primitive Type)
		// new 키워드를 이용해서 생성함.
		// 모든 비기본자료형의 기본 값은 Null임.
		// 실제 값이 아닌 객체의 주소를 가지고 있는 자료형으로 값을 객체의 주소에 의해서 참조하는 자료형임.
		String fruit = "Apple";
		System.out.println(fruit);
		System.out.println(fruit.toUpperCase());
		System.out.println(fruit.toLowerCase());

		// 다음과 같을 경우 str2 변수 선언시 메모리에 "Hello"가 있는지 찾고,
		// 있을 경우 해당 메모리 주소를 str2가 참조하게 됨.
		// 두 변수의 메모리 주소가 같은걸 확인할 수 있음.
		String str1 = "Hello";
		String str2 = "Hello";
		// str1의 메모리 주소가 변경되는 것을 확인 할 수 있음.
		str1 = "Bye";
		System.out.println(str1 + ", " + str2);
		// 그에 비해 기본 자료형의 경우 주소가 들어가지않고 각각의 값만 들어감.
		int int1 = 10;
		int int2 = 10;
		System.out.println(int1 + ", " + int2);
	}
}
