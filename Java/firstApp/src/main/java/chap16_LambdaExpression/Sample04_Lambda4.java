package chap16_LambdaExpression;

import java.util.Scanner;
import java.util.function.Predicate;

public class Sample04_Lambda4 {

	public static void main(String[] args) {
		// Predicate
		Predicate<Integer> isOdd = (s) -> (s % 2) == 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("홀수를 입력하세요 : ");
		if (sc.hasNextInt()) {
			// test() 메서드는 1개의 매개변수를 받아서 boolean 자료형으로 결과를 반환함
			System.out.println(isOdd.test(sc.nextInt()));
		}else {
			System.out.println("숫자가 아닙니다.");
		}
		sc.close();
		System.out.println();
		
		// and() 메서드
		// 조건식 2개를 넣고 and연산함
		Predicate<Integer> isMin = (s) -> (s > 10);
		Predicate<Integer> isMax = (s) -> (s < 20);
		System.out.println(isMin.and(isMax).test(12));
		System.out.println(isMin.and(isMax).test(32));
	}

}
