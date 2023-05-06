package chap16;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Sample02 {

	public static void main(String[] args) {
		// 함수형 인터페이스 API

		// Runnable void run() 없음
		// Supplier T get() 없음
		// Consumer void accept(T t) 1개
		// Function<T,R> R apply(T t) 1개
		// Predicate boolean test(T t) 1개
		// UnaryOperator T apply(T t) 1개
		// BiConsumer<T,U> void accept(T t,U u) 2개
		// BiFunction<T,U,R> R apply(T t,U u) 2개
		// BiPredicate<T,U> boolean test(T t,U u) 2개
		// BinaryOperator T apply(T t,U u) 2개
		// 매개변수가 없는 함수형 인터페이스
		// Runnable - 매개변수도 없고 반환할 자료형도 없이 내부적으로 처리만 할 경우에 사용
		Runnable r = () -> {
			System.out.println("Runnable");
		};
		r.run();
		// Supplier는 반환할 자료형을 제네릭으로 자료형을 선언한 후에 실행문에 제네릭으로 선언한 자료형을 반환할 경우에 사용
		Supplier<String> s = () -> "Supplier";
		System.out.println(s.get());
		// return문을 넣어서 구현
		Supplier<String> s2 = () -> {
			return "Supplier2";
		};
		System.out.println(s2.get());

		// 참조 자료형으로 클래스를 만들어서 클래스의 멤버 변수에 생성자를 통해서 값을 받고 매개변수로 람다식을 이용하여 멤버 변수의 내용 출력하기.
		MessageCenter mc = getMsg(() -> new MessageCenter("MessageCenter"));
		System.out.println(mc);

		// 매개변수가 한 개인 함수형 인터페이스
		// 매개변수가 한 개일 때는 괄호를 생략할 수 있음.
		Consumer<String> c = x -> {
			System.out.println(x.toUpperCase());
		};
		c.accept("Consumer");

		List<Employee> emp = Arrays.asList(new Employee(1, "A", 2400), new Employee(2, "B", 2700),
				new Employee(3, "C", 3000), new Employee(4, "D", 3200));
		System.out.println("연봉 2배 출력");
		emp.forEach((x) -> {
			x.setSalary(x.getSalary() * 2);
			System.out.println(x);
		});

		// Function 함수형 인터페이스
		// Fuction 함수형 인터페이스는 Consumer와는 다르게 결과를 반환할 수 있음.
		Function<Integer, String> f = (i) -> {
			switch (i) {
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		};
		System.out.println(f.apply(3));
		// compose()는 선행 함수를 실행한 후 현재의 람다식을 수행함.
		int myMoney = 100000;
		// 10% 세금을 납부
		Function<Integer, Integer> work = (money) -> {
			System.out.printf("* [%d] 세금을 납부합니다.\n", (int) (money * 0.1));
			return money = (int) (money * 0.9);
		};
		// 수입금을 더함
		Function<Integer, Integer> before = (income) -> {
			System.out.printf("* [%d] 수입이 발생했습니다.\n", income);
			return income;
		};
		// work 람다식 호출
		myMoney = work.apply(myMoney);
		printInfo(myMoney);
		myMoney += work.compose(before).apply(30000);
		printInfo(myMoney);
	}

	public static void printInfo(int myMoney) {
		DecimalFormat df = new DecimalFormat("##,###,###");
		System.out.println("잔액 : " + df.format(myMoney));
	}

	public static MessageCenter getMsg(Supplier<MessageCenter> mc) {
		return mc.get();
	}

}

@RequiredArgsConstructor
class MessageCenter {

	private final String msg;

	@Override
	public String toString() {
		return msg;
	}
}

@Data
@AllArgsConstructor
class Employee {
	private int no;
	private String name;
	private double salary;
}