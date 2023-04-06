package chap06;

public class Sample01 {

	public static void main(String[] args) {
		var Hello = "HelloWorld!";
		char[] chr = Hello.toCharArray();
		for (int i = 0; i < chr.length; i++) {
			System.out.print(chr[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			System.out.println();
		}
		// 향상된 for문
		for (char c : chr) {
			System.out.println(c);
		}
		// While
		int idx = 0;
		do {
			if (idx > 10) {
				break;
			}
			if (idx % 2 == 0) {
				continue;
			}
			idx++;
		} while (true);

	}
}
