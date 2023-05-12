package chap16_LambdaExpression;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Sample09_MethodReference3 {

	public static void main(String[] args) {
		// 특정 타입의 임의 개체에 대한 인스턴스 메서드 참조
		// 인스턴스의 원형 객체명을 적어주고 더블 콜론 다음에 메서드명을 적어주면 됨
		var list = Arrays.asList( new Person(1, "A")
								, new Person(2, "B")
								, new Person(3, "C")
								, new Person(4, "D"));
		System.out.println("람다식");
		list.forEach(x -> x.toObjString());
		System.out.println("메서드 참조");
		list.forEach(Person::toObjString);
	}

}

@Getter
@Setter
@AllArgsConstructor
class Person {
	private Integer no;
	private String name;

	public void toObjString() {
		System.out.println("Person [no=" + no + ", name=" + name + "]");
	}
}