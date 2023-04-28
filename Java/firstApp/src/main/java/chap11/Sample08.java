package chap11;

import java.util.ArrayList;
import java.util.TreeSet;

public class Sample08 {

	public static void main(String[] args) {
		// 트리 -> 하나의 Node에 여러 자식 노드가 있음
		// 여기서는 이진트리(Binary Tree)사용
		// 이진 트리는 각 노드의 자식 노드가 최대 두 개로, 왼쪽 한개 오른쪽 한 개를 가짐.
		// 이진 트리의 모든 노드를 방문하는 방법을 순회라고 하며, 이진 트리 순회 방법으로는 일반적으로 4가지 방법이 있음.
		// 1. in-order(중위 순회): 왼쪽 자식 노드, 부모 노드, 오른쪽 자식 노드 순서로 방문
		// 2. pre-order(전위 순회): 부모 노드, 왼쪽 자식 노드, 오른쪽 자식 노드 순서로 방문
		// 3. post-order(후위 순회): 왼쪽 자식 노드, 오른쪽 자식 노드, 부모 노드 순서로 방문
		// 4. level-order(레벨 순회): 부모 노드, 부모 노드로부터 깊이 1인 노드들, 부모 노드로부터 깊이 2인 노드들,..
		// TreeSet은 검색 시에 중위 순회 탐색 방법으로 검색함.
		// 4
		// 2 5
		// 1 3
		// 노드 수 : 5개
		// 깊이 : 2
		// 4의 깊이가 0, 2,5의 깊이는 1, 1,3의 깊이는 2이다.
		// add()
		// addall()
		// higher() - 지정된 요소보다 큰 가장 가까운 값 반환
		// ceiling() - 지정된 요소보다 크거나 같은 것 중 제일 가까운 값 반환
		// floor() - 지정된 요소보다 작거나 같은 것 중 제일 가까운 값 반환
		// lower() - 지정된 요소보다 작은 가장 가까운 값 반환
		// clear()
		// contains()
		// descendingIterator() - 요소들을 Iterator 내림차순으로 반환
		// first() - 첫번째 요소를 반환
		// last() - 마지막 요소를 반환
		// pollfirst() - 첫번째 요소를 반환 후 삭제
		// pollLast() - 마지막 요소를 반환 후 삭제
		// remove() - 지정된 요소를 제거
		// size() - 요소의 수를 반환
		var arr = new ArrayList<String>();
		arr.add("사자");
		arr.add("호랑이");
		arr.add("원숭이");

		System.out.println("1 > ArrayList를 TreeSet으로 가져옴");
		var trs = new TreeSet<String>();
		trs.addAll(arr);
		System.out.println("TreeSet : " + trs);

		System.out.println("2 > TreeSet에 타이거를 추가함");
		trs.add("타이거");
		System.out.println("TreeSet : " + trs);

		String addStr = "토끼";
		System.out.printf("3 > TreeSet에 %s가 없으면 추가\n", addStr);
		if (trs.contains(addStr)) {
			System.out.printf("이미 %s가 존재합니다.\n", addStr);
		} else {
			trs.add(addStr);
			System.out.printf("%s를 추가합니다.\n", addStr);
		}

		System.out.println("TreeSet : " + trs);

		System.out.println("4 > '자'보다 크거나 같은 값 중에 제일 가까운 값을 출력함");
		System.out.println(trs.ceiling("자"));

		System.out.println("5 > '자'보다 작거나 같은 값 중에 제일 가까운 값을 출력함");
		System.out.println(trs.floor("자"));

		System.out.println("6 > '토끼'보다 큰 값을 출력함");
		System.out.println(trs.higher("토끼"));		

		System.out.println("7 > '토끼'보다 작은 값을 출력함");
		System.out.println(trs.lower("토끼"));
		
		System.out.println("8 > 첫번째 값 출력");
		System.out.println(trs.first());
		
		System.out.println("9 > 마지막 값 출력");
		System.out.println(trs.last());
	}

}
