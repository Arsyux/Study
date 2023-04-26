package chap11;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sample02 {

	static List<String> list1 = new ArrayList<>();
	static List<String> list2 = new LinkedList<>();

	public static void main(String[] args) {
		// 1. 순차 입력
		list1.add("a");
		list1.add("b");
		list1.add("c");

		list2.add("a");
		list2.add("b");
		list2.add("c");
		toString("1. 순차입력");
		
		// 2. 삽입
		list1.add(2, "tiger");
		list2.add(2, "tiger");
		toString("2. 중간삽입");
		
		// 3. 중간삭제
		list1.remove(2);
		list2.remove(2);
		toString("3. 중간삭제");
	}

	public static void toString(String title) {
		System.out.printf("== %s ==\n", title);
		System.out.println("ArrayList : " + list1);
		System.out.println("LinkedList: " + list2);
		System.out.println();
	}

}
