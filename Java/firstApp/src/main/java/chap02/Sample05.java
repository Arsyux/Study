package chap02;

public class Sample05 {

	public static void main(String[] args) {
		// var : 지역 변수의 타입 추론 (Local variable type inference)
		// null사용 불가, 선언시 값을 넣어주어야함.
		var v1 = "Age : ";
		var v2 = 30;
		System.out.println(v1 + v2);
		// 상수 (const)
		// 상수는 값 변경이 불가능
		final String s = "Age : ";
		final int f = 31;
		System.out.println(s + f);
		// 계산에 사용은 가능
		System.out.println(v2 + f);
	}
}
