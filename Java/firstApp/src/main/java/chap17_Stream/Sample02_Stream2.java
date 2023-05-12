package chap17_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample02_Stream2 {

	public static void main(String[] args) {
		// 사용자가 덩의한 class자료형을 스트림으로 처리
		DataObj[] data = { new DataObj(1, "A"), new DataObj(2, "B"), new DataObj(3, "C") };
		Stream<DataObj> stm = Arrays.stream(data);
		stm.forEach(System.out::println);
		System.out.println();
		
		// 스트림 생성후 바로 출력하는것도 가능함
		Arrays.stream(data).forEach(System.out::println);
	}

}

@Data
@AllArgsConstructor
class DataObj {
	int no;
	String name;
}