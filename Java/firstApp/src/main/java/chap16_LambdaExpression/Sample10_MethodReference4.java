package chap16_LambdaExpression;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import lombok.Getter;

public class Sample10_MethodReference4 {

	public static void main(String[] args) {
		// 생성자 참조
		// 생성자도 똑같이 참조할 수 있음.
		// 객체명과 더블 콜론이 위치하고 이어서 new 키워드를 사용함.
		// 생성자 참조 기본 문법
		// (Object name)::new
		Supplier<Name> s1 = () -> new Name();
		Name n1 = s1.get();
		System.out.println("람다식 : " + n1.getName());

		Supplier<Name> s2 = Name::new;
		Name n2 = s2.get();
		System.out.println("생성자 참조 : " + n2.getName());

		// 인자가 있는 생성자 참조
		BiConsumer<Integer, Integer> p1 = (a, b) -> new Plus(a, b);
		System.out.print("람다식 : ");
		p1.accept(1, 2);
		BiConsumer<Integer, Integer> p2 = Plus::new;
		System.out.print("생성자 참조 : ");
		p2.accept(3, 4);

		// 인터페이스를 직접 만들어서 인자에 의한 생성자를 참조하는 코드
		// 인자 없는 생성자
		HelloYourName1 hy1 = Hello::new;
		System.out.println(hy1.get().getName());
		// 인자가 있는 생성자
		HelloYourName2 hy2 = Hello::new;
		System.out.println(hy2.get("B").getName());
	}

}

@Getter
class Name {
	private String name;

	public Name() {
		this.name = "A";
	}
}

class Plus {
	public Plus(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}
}

interface HelloYourName1 {
	Hello get();
}

interface HelloYourName2 {
	Hello get(String name);
}

class Hello {
	private String name;

	public Hello() {
		this.name = "A";
		System.out.println("인자 없는 생성자 호출");
	}

	public Hello(String name) {
		this.name = name;
		System.out.println("인자가 있는 생성자 호출");
	}

	public String getName() {
		return name;
	}
}