package chap11;

import java.util.ArrayList;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample06 {

	public static void main(String[] args) {
		var list = new ArrayList<Employee>();
		list.add(new Employee(1, "a"));
		list.add(new Employee(2, "b"));
		list.add(new Employee(4, "d"));
		list.add(new Employee(3, "c"));
		
		System.out.println(list.toString());
		Collections.sort(list);
		System.out.println(list.toString());
	}

}

// Collections.sort()사용할 수 있게 하기
// Comparable<T>를 implements하여 compareTo()메서드를 Override해야함.
@Data
@AllArgsConstructor
class Employee implements Comparable<Employee> {
	private int number;
	private String name;

	@Override
	public int compareTo(Employee e) {
		// name을 기준으로 정렬
		//return this.name.compareTo(e.name); // 순정렬
		//return e.name.compareTo(this.name); // 역정렬
		// number를 기준으로 정렬
		//return this.number - e.number; // 순정렬
		return e.number - this.number;// 역정렬
	}
}