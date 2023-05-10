package chap08;

@FunctionalInterface
interface Runnable {
	public abstract void run();
}

class Student {
	static int age;

	public Student(int age) {
		Student.age = age;
	}
	
	// 정적 중첩 클래스 (Static Nested Classes)
	// 중첩 클래스는 다른 클래스안에 정의된 클래스.
	// 그냥 정의하면 인스턴스 클래스, static을 붙히면 정적 멤버 클래스가 됨.
	// 내부 클래스를 사용하기 위해서는 외부 클래스의 인스턴스를 생성한 뒤에
	// 다시 내부 클래스의 인스턴스를 생성해야지 사용할 수 있음.
	public static class Score {
		int eng;
		int mat;

		public Score(int age) {
			// 내부 클래스의 this는 내부 클래스를 참조하기때문에 Student를 직접 참조.
			Student.age = age;
		}

		public void show() {
			System.out.println("Age: " + age);
			System.out.println("Eng: " + eng);
			System.out.println("Mat: " + mat);
		}
	}
}

public class Sample03 {

	public static void main(String[] args) {
		String name = "Arsyux";
		// 익명 내부 클래스 (Anonymous Inner classes)
		// 클래스가 따로 존재하지않고 객체를 생성해서 바로 사용.
		// 만들어진 지역(Local)에서만 사용가능.
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Name: " + name);
			}
		};
		r.run();
		Student.Score s = new Student.Score(20);
		s.eng = 100;
		s.mat = 100;
		s.show();
	}
}