package chap08.vo;

// lombok 사용
// @Data이 포함하는 것
// - @ToString
// - @EqualsAndHashCode
// - @Getter
// - @Setter
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Sample06 {

	@NonNull
	private String d;
	private int a;
	private int b;
	private int c;
	@NonNull
	private String e;

	@Builder
	public Sample06(String d, int a, int b) {
		this.d = d;
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		Sample06 s = new Sample06();
		s.setA(0);
		s.setB(1);
		s.setC(2);
		s.setD("3");
		System.out.println(s.toString());
		Sample06 s2 = new Sample06("D", "E");
		System.out.println(s2.toString());
		Sample06 s3 = Sample06.builder()
							  .d("Hello")
							  .a(100)
							  .b(200)
							  .build();
		System.out.println(s3.toString());
	}

}
