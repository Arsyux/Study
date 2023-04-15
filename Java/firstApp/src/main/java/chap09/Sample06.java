package chap09;

import java.util.UUID;

public class Sample06 {

	public static void main(String[] args) {
		String legacyKey = LagacyUtil.getRandom();
		System.out.println("레거시 키 값: " + legacyKey);

		for (int i = 0; i < 5; i++) {
			String key = NewUtil.getRandom();
			System.out.println("새로운 키 값: " + key);
		}
	}
}

class LagacyUtil {
	public static String getRandom() {
		return (int) (Math.random() * 10 + 1) + "";
	}
}

// 상속의 활용
class NewUtil extends LagacyUtil {

	// 변경된 부분만 override하여 재구현
	public static String getRandom() {
		return UUID.randomUUID() + "";
	}
}
