package chap18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sample01 {

	public static void main(String[] args) {
		// 예외 (Exception)
		try {
			int[] arr = new int[10];
			for (int i = 0; i < 100; i++) {
				arr[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// 개발 중에 일부러 오류를 발생시켜서 프로세스를 중지시키기 위해서 종종사용하는 방법
		try {
			IntStream.rangeClosed(1, 5).forEach(System.out::print);
			System.out.println();
			System.out.println(1 / 0);
		} catch (ArithmeticException e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// finally 사용
		String result = "";
		try {
			IntStream.rangeClosed(1, 5).forEach(System.out::print);
			System.out.println();
			System.out.println(1 / 0);
			result = "처리 완료!";
		} catch (ArrayIndexOutOfBoundsException e) {
			result = "오류 발생 - " + e.getMessage();
		} catch (ArithmeticException e) {
			result = "오류 발생 - " + e.getMessage();
		} catch (Exception e) {
			result = "오류 발생 - " + e.getMessage();
		} finally {
			System.out.println(result);
		}

		// throw
		// 오류 던지기
		try {
			throw new Exception("Hello, Exception!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// throws
		// 오류가 발생한 영역에서 try문을 이용하여 오류를 예외처리하지 않고 현재 영역을 호출한 상위 영역에 오류를 위임하여 처리하게 함
		try {
			excute();
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// Custom Exception
		try {
			List<String> list1 = Arrays.asList("밥", "사탕", "커피");
			// List<String> list1 = Arrays.asList("밥", "사탕", "커피", "빵", "커피빵");
			hasBread(list1);
			System.out.println("빵이 잘 포함되었습니다.");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// try-with-resource
		// 먼저 AutoCloseable인터페이스를 살펴보면 close() throws Exception 메서드가 있음
		// 결국 AutoCloseable인터페이스를 사용하게 되면 try-catch문을 이용해서 예외처리를 해야함.
		// 예외가 발생하면 IOException을 위임함.
		// AutoMachine.java 5줄에서 AutoMachine객체는 try문에서 사용할 객체로 하나를 만들어 놓고 계속 사용하고자함.
		// AutoMachine 동작을 마무리하고자 할 때 close() 메서드를 반드시 실행시켜야 함.
		// 그런데 close() 메서드도 try문 내에서 작성되어야 함.
		// 이걸 편하게 하기위해 java7에서 추가되었음
		try (AutoMachine m = AutoMachine.getInstance()) {
			m.run();
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		} finally {
			// Closable에 의해 구현된 객체의 close()를 구현할 필요는 없음.
			// close() 메서드를 호출하지 않았는데도 자동으로 호출하였음.
		}
		System.out.println();
		// 여러개의 객체 사용
		try (AutoMachine m = AutoMachine.getInstance(); AutoMachine2 m2 = AutoMachine2.getInstance()) {
			m.run();
			m2.run();
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		} finally {
			System.out.println("모든 AutoMachine이 종료되었습니다.");
		}
		System.out.println();
		// 가독성 수정
		AutoMachine auto1 = AutoMachine.getInstance();
		AutoMachine2 auto2 = AutoMachine2.getInstance();
		try (auto1; auto2) {
			auto1.run();
			auto2.run();
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		} finally {
			System.out.println("모든 AutoMachine이 종료되었습니다.");
		}
	}

	public static void excute() throws Exception {
		throw new Exception("excute() 에러!");
	}

	public static void hasBread(List<String> list) throws BreadException {
		System.out.println("빵 개수 : " + list.stream().filter(x -> x.contains("빵")).count());
		if (list.stream().filter(x -> x.contains("빵")).count() <= 0) {
			throw new BreadException();
		}
	}
}

class BreadException extends Exception {

	private static final long serialVersionUID = 1L;

	public BreadException() {
		super("빵이 포함되지 않는 오류 발생!");
	}

}