package chap02;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력해주세요.");
		if (sc.hasNextDouble()) {
			System.out.println("입력하신 문자는 숫자입니다. ");
		} else {
			System.out.println("입력하신 문자는 숫자가 아닙니다.");
		}
		sc.close();
	}
}
