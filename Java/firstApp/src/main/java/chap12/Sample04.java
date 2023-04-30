package chap12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Sample04 {

	public static void main(String[] args) {
		FLOWER1 f1 = FLOWER1.SUNFLOWER;
		System.out.println(f1.getName());
		
		FLOWER2 f2 = FLOWER2.ROSE;
		System.out.println(f2.getName());
	}

}

// 값을 갖는 열거형
enum FLOWER1 {
	SUNFLOWER("sunflower"), ROSE("rose");

	private final String name;

	private FLOWER1(String flowerName) {
		this.name = flowerName;
	}

	public String getName() {
		return this.name;
	}
}

// Lombok사용
@RequiredArgsConstructor
@Getter
enum FLOWER2 {
	SUNFLOWER("sunflower"), ROSE("rose");

	private final String name;

}