
package chap17_Stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample06_Stream6 {

	public static void main(String[] args) {
		// 범위 (Range)
		// Stream API중 range()와 rangeClosed()
		// 이 둘의 차이점은 마지막 수를 포함하느냐 여부
		// 1~10까지의 수를 Stream으로 생성할때는 다음과 같이 구현함
		// IntStream.range(1, 11);
		// IntStream.rangeClosed(1, 10);
		// 정수를 반환하기 때문에 range()메서드와 rangeClosed() 메서드는
		// IntStream과 LongStream클래스에서만 사용할 수 있음.
		// for(int i= 12; i <= 18; i++) { System.out.println(i); }
		IntStream.rangeClosed(12, 18).forEach(System.out::println);

		// rangeClosed() 메서드를 활용하여 더미(dummy) 데이터 생성
		List<Board> boardList = new ArrayList<Board>();
		IntStream.rangeClosed(1, 100).forEach(i -> {
			boardList.add(new Board(i, "title_" + i, "user_" + i, LocalDateTime.now()));
		});
		boardList.stream().forEach(System.out::println);
	}

}

@Data
@AllArgsConstructor
class Board {
	int no;
	String title;
	String user;
	LocalDateTime createdate;
}