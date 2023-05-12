package chap08_OOP;

public class Sample04_AccessModifier {

	// 접근 제어자
	// public : 아무런 제약 없이 모든 접근이 허용됨.
	public String name;

	// protected : 같은 패키지의 객체와 상속 관계에 있는 개체까지만 접근이 허용된다.
	protected int age;

	// default : 해당 패키지 내에서만 접근이 허용된다.
	int eng;

	// private : 해당 class내에서만 접근이 허용된다.
	private int mat;

	public Sample04_AccessModifier(String name) {
		this.name = name;
		this.age = 20;
		this.eng = 30;
		this.mat = 40;
	}

	@Override
	public String toString() {
		return "Sample04 [name=" + name + ", age=" + age + ", eng=" + eng + ", mat=" + mat + "]";
	}

	public static void main(String[] args) {
		String str1 = new String("A");
		String str2 = "A";
		String str3 = "A";

		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 주소입니다.");
		} else {
			System.out.println("str1과 str2는 다른 주소입니다.");
		}

		if (str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}

		if (str2 == str3) {
			System.out.println("str2와 str3은 같은 주소입니다.");
		} else {
			System.out.println("str2와 str3은 다른 주소입니다.");
		}

		if (str2.equals(str3)) {
			System.out.println("str2와 str3은 같은 값입니다.");
		} else {
			System.out.println("str2와 str3은 다른 값입니다.");
		}

		Sample04_AccessModifier s = new Sample04_AccessModifier("이름");
		System.out.println(s.toString());

		Sample04_AccessModifier[] arr_s = new Sample04_AccessModifier[2];
		arr_s[0] = new Sample04_AccessModifier("1");
		arr_s[1] = new Sample04_AccessModifier("2");
		for (Sample04_AccessModifier sam : arr_s) {
			System.out.println(sam.toString());
		}
	}
}
