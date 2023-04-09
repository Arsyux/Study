package chap08.vo;

public class Sample02 {

	// 인스턴스 내부 클래스 (Instance Inner classes)
	// 외부 클래스의 멤버 클래스로 멤버 변수와 같은 레벨에 위치함.
	public class Score {
		int eng;
		int mat;

		public void showInfo() {
			// 외부 클래스(Sample02)의 자원에 쉽게 접근 가능
			System.out.println("name: " + name);
			System.out.println("eng: " + eng);
			System.out.println("mat: " + mat);
		}

	}

	void LocalMethod() {
		int age = 20;
		// 지역클래스 (Local Inner Classes)
		// 클래스 안에 메서드가 있고 그 메서드 내에 내부 클래스가 들어가 있는 형태.
		class LocalClass {
			public void myAge() {
				System.out.println("age: " + age);
			}
		}
		
		LocalClass innerClass = new LocalClass();
		innerClass.myAge();
	}

	String name;

	public Sample02(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// 인스턴스 내부 클래스
		Sample02 s = new Sample02("Arsyux");
		Sample02.Score ss = s.new Score();
		ss.eng = 100;
		ss.mat = 50;
		ss.showInfo();
		s.LocalMethod();
	}
}
