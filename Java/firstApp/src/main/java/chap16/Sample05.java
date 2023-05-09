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

		Predicate<List<Integer>> isLucky = Predicate.isEqual(luckyNumber);

		// 내 번호
		List<Integer> myNum = CreateNumber();
		System.out.println("내 번호  : " + myNum);
		if(isLucky.test(myNum)) {
			System.out.println("복권 당첨!");
		}else {
			System.out.println("복권에 당첨되지 못했습니다.");
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
