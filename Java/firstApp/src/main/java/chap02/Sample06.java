package chap02;

import java.util.Random;

public class Sample06 {

	public static void main(String[] args) {
		// Random값 생성
		// 1. Random객체 사용.
		Random r = new Random();
		// 1~100 출력
		System.out.println(r.nextInt(100) + 1);
		// 2. Math.random() 사용.
		// 1~50 출력
		System.out.println((int) (Math.random() * 50 + 1));
	}
}
