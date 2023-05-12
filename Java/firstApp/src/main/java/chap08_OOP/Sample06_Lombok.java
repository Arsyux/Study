package chap08_OOP;

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
public class Sample06_Lombok {

	@NonNull
	private String d;
	private int a;
	private int b;
	private int c;
	@NonNull
	private String e;

	@Builder
	public Sample06_Lombok(String d, int a, int b) {
		this.d = d;
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		Sample06_Lombok s = new Sample06_Lombok();
		s.setA(0);
		s.setB(1);
		s.setC(2);
		s.setD("3");
		System.out.println(s.toString());
		Sample06_Lombok s2 = new Sample06_Lombok("D", "E");
		System.out.println(s2.toString());
		Sample06_Lombok s3 = Sample06_Lombok.builder()
							  .d("Hello")
							  .a(100)
							  .b(200)
							  .build();
		System.out.println(s3.toString());
	}

}
