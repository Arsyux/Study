package chap07_ConditionalStatements;

public class Sample01_ConditionalStatements {

	public static void main(String[] args) {
		// 조건문
		int num = 5;
		if (num <= 10) {
			System.out.println("num이 10이하입니다.");
		} else if (num > 10 && num < 20) {
			System.out.println("num이 10초과 20미만입니다.");
		} else {
			System.out.println("num이 20이상입니다.");
		}
		// switch문
		switch (num) {
		case 5:
			System.out.println("num은 5입니다.");
			break;
		default:
			System.out.println("num은 5가 아닙니다.");
			break;
		}
		/*
		// JDK12에서 추가된 switch 기능
		switch (num) {
		case 1, 3, 5, 7, 9:
			System.out.println("num은 홀수 입니다.");
			break;
		case 2, 4, 6, 8, 10:
			System.out.println("num은 짝수 입니다.");
			break;
		default:
			System.out.println("num은 1~10사이의 수가 아닙니다.");
			break;
		}
		// 향상된 switch case문 사용1
		switch(변수 or 연산식) {
		case 비교값1 -> (실행문)
		case 비교값2, 비교값3 -> (실행문)
		default -> (실행문)
		}
		// 향상된 switch case문 사용2
		[변수] = switch(변수 or 연산식){
		case 비교값1 -> 반환값1
		case 비교값2, 비교값3 -> 반환값2
		default -> 반환값3
		}
		// 향상된 switch case문 사용3
		[변수] = switch(변수 or 연산식){
		case 비교값1:
		case 비교값2:
			break 반환값1;
		case 비교값3:
			break 반환값2;
		default:
			break 반환값3;
		}
		// JDK 13에서의 사용 break => yield로 변경
		String season = switch(in){
		case 12, 1, 2: yield "겨울";
		default : yield "겨울이 아닙니다";
		}
		*/
	}
}
