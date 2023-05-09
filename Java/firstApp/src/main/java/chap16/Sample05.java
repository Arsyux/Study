package chap16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Sample05 {

	public static void main(String[] args) {
		// 복권 당첨 번호 생성
		List<Integer> luckyNumber = CreateNumber();
		System.out.println("복권 번호 : " + luckyNumber.toString());

		// isEqual()
		// 람다식에 특정 값을 넣어놓고 그 값과 비교하여 같으면 true를 반환하고 다르면 false를 반환함
		Predicate<List<Integer>> isLucky = Predicate.isEqual(luckyNumber);

		// 내 번호
		List<Integer> myNum = CreateNumber();
		System.out.println("내 번호  : " + myNum);
		if (isLucky.test(myNum)) {
			System.out.println("복권 당첨!");
		} else {
			System.out.println("복권에 당첨되지 못했습니다.");
		}

		// negate()
		// boolean값으로 나온 값의 반대 값을 갖게됨.
		Predicate<Integer> isOdd = (s) -> (s % 2) == 1;
		int n = 11;
		System.out.println("11의 test()값 : " + isOdd.test(n));
		System.out.println("11의 negate().test()값 : " + isOdd.negate().test(n));

		// not()
		// 반대의 결과가 나오는 람다식으로 변환함
		Predicate<Integer> isEven = Predicate.not(isOdd);
		n = 14;
		System.out.println("14는 짝수입니까? " + isEven.test(n));

		// or()
		// OR연산에 의해서 적어도 하나만 참이면 모두 참
		Predicate<Integer> isMulTwo = (s) -> (s % 2) == 0;
		Predicate<Integer> isMulThree = (s) -> (s % 3) == 0;
		if (isMulTwo.or(isMulThree).test(15)) {
			System.out.println("15는 2의 배수거나 3의 배수입니다.");
		} else {
			System.out.println("15는 2의 배수거나 3의 배수가 아닙니다.");
		}
	}

	public static ArrayList<Integer> CreateNumber() {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int cnt = 0;
		while (cnt < 6) {
			int val = new Random().nextInt(45);
			if (!lst.contains(val)) {
				lst.add(val);
				cnt++;
			}
		}
		return lst;
	}
}
