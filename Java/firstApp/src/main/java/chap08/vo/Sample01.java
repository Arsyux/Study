// 패키지
package chap08.vo;

// 클래스
class CLASSVO {
	public CLASSVO() {

	}

	/* 필드 영역 시작 */
	String name;
	private int age;
	/*
	 * static final int ONE = 1; static final int TWO = 2; static final int THREE =
	 * 3;
	 */
	// static block
	static final int ONE;
	static final int TWO;
	static final int THREE;
	static {
		System.out.println("호출");
		ONE = 1;
		TWO = 2;
		THREE = 3;
	}

	// Setter
	public void setAge(int myAge) {
		age = myAge;
	}

	// Getter
	public int getAge() {
		return age;
	}

	public void Hello() {
		System.out.println("Hello, World!");
	}

	// Overloading
	public void Hello(String name) {
		System.out.println("Hello, " + name);
	}

	// 가변인자
	public int Sum(int... a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		return total;
	}

}

// 접근 제어자
// private
// default
// protected
// public
public class Sample01 {

	public static void main(String[] args) {
		CLASSVO cv = new CLASSVO();
		cv.setAge(20);
		System.out.println(cv.getAge() + CLASSVO.ONE);
		cv.Hello("World!");
		System.out.println(cv.Sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}
}
