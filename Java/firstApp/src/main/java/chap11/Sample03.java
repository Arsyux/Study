package chap11;

import java.util.Stack;

public class Sample03 {

	public static void main(String[] args) {
		var stack = new Stack<Integer>();
		
		stack.add(1);
		stack.add(2);
		stack.add(3);
		System.out.printf("Size() : %d\n", stack.size());
		
		while(!stack.isEmpty()) {
			// 객체를 반환만하고 제거하지 않길 원한다면
			//stack.peek();
			System.out.println(stack.pop());
		}
		
		System.out.printf("Size() : %d", stack.size());
	}

}
