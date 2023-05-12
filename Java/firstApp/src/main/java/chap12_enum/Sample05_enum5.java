package chap12_enum;

import java.util.EnumSet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Sample05_enum5 {

	public static void main(String[] args) {
		System.out.println("1. 동물원의 조류의 수");
		System.out.printf("%s, %d마리\n", BIRD.SPARROW.getName(), BIRD.SPARROW.getCount());
		System.out.printf("%s, %d마리\n", BIRD.PARROT.getName(), BIRD.PARROT.getCount());
		System.out.printf("%s, %d마리\n", BIRD.EAGLE.getName(), BIRD.EAGLE.getCount());
		System.out.printf("%s, %d마리\n", BIRD.FALCON.getName(), BIRD.FALCON.getCount());

		// 반복문을 통해 한번에 출력
		System.out.println("2. 동물원의 조류의 수");
		// EnumSet은 Set의 Enum 버전임.
		EnumSet<BIRD> birds = EnumSet.allOf(BIRD.class);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}

		System.out.println("3. 동물원의 조류의 수");
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}
		System.out.println("4. 독수리 삭제");
		birds.remove(BIRD.EAGLE);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}
		System.out.println("5. 독수리 추가");
		birds.add(BIRD.EAGLE);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}
	}

}

// 여러개의 값을 갖는 열거형
@RequiredArgsConstructor
@Getter
enum BIRD {
	SPARROW("참새", 33), PARROT("앵무새", 27), EAGLE("독수리", 2), FALCON("매", 8);

	// 값이 3개면 늘리면됨.
	private final String name;
	private final int count;
}