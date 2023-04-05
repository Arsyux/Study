package chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample01 {
	public static void main(String[] args) {
		// 배열
		// (자료형)[] 이름 = new 자료형(배열의 개수)
		int[] arr1 = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
			System.out.println(arr1[i]);
		}
		int[] arr2 = { 100, 200, 300 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		// 다차원 배열
		int[][] arr3 = new int[5][3];
		// 특정 줄만 재정의하기
		arr3[1] = new int[1];
		// 행의 길이
		System.out.println("길이 : " + arr3.length);
		System.out.println("특정 행의 길이 : " + arr3[0].length);
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.println(i + ", " + j);
			}
		}
		// Split사용하기
		String str = "A|B|C|D|E";
		// \\|, \\&, \\*, =, \\+, \\^, - 등등..
		String[] names = str.split("\\|");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		// Arrays 클래스
		// Arrays.toString()
		// 1차원 배열만 출력가능
		System.out.println(Arrays.toString(names));
		// Arrays.deepToString()
		// 2차원 이상도 사용가능
		System.out.println(Arrays.deepToString(arr3));

		String[] names2 = str.split("\\|");
		// 배열의 비교
		// 잘못된 비교의 예
		System.out.println(names == names2);
		// Arrays.equals()
		System.out.println(Arrays.equals(names, names2));
		// 다차원은 Arrays.deepEquals()
		System.out.println(Arrays.deepEquals(names, names2));
		// Arrays.copyOf()
		// 배열을 0부터 정해진 길이만큼 복사함.
		// A, B, C, D, E
		// A, B
		String[] names3 = Arrays.copyOf(names2, names2.length - 3);
		System.out.println(Arrays.toString(names3));
		// 배열을 정해진 범위만큼 복사함
		// C, D
		String[] names4 = Arrays.copyOfRange(names2, 2, 4);
		System.out.println(Arrays.toString(names4));
		// Arrays.sort()
		// 오름차순으로 정렬
		String[] names5 = { "D", "B", "A", "C", "F", "E" };
		Arrays.sort(names5);
		System.out.println(Arrays.toString(names5));
		// Arrays.binarySearch()
		// 이진 탐색은 해당 배열이 미리 정리되어있어야함.
		// 해당하는 Key의 index값을 return함.
		System.out.println(Arrays.binarySearch(names5, "B"));
		// Arrays.asList()
		// List자료형에 배열을 쉽게 추가하는 메서드
		int[] arr_int1 = { 1, 2, 3 };
		int[] arr_int2 = { 5, 6, 7 };
		
	}
}
