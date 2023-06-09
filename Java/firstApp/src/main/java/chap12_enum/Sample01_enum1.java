package chap12_enum;

public class Sample01_enum1 {

	public static void main(String[] args) {
		// 색 집합
		final int RED = 1;
		final int BLUE = RED + 1;
		final int ORANGE = BLUE + 1;

		// 크기 집합
		final int SMALL = 1;
		final int MIDIUM = SMALL + 1;
		final int LARGE = MIDIUM + 1;

		int inputColor = RED;

		System.out.println(inputColor == RED ? "Red" : "Not Red");
		// 색과 크기를 비교하였는데 색으로 결과값이 나옴.
		System.out.println(inputColor == SMALL ? "Red" : "Not Red");
		System.out.println("ORANGE : " + ORANGE);
		System.out.println("LARGE  : " + LARGE);
	}

}
