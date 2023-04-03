package chap02;

public class Sample07 {

	public static void main(String[] args) {
		// 카멜 표기법(Camel Case)
		// 맨 첫 단어를 제외한 단어의 조합 중 띄어쓰기 대신에 각 단어의 첫 문자를 대문자로 표기하고
		// 나머지 문자는 소문자로 표기함.
		// 실무에서 제일 많이 사용함.
		String textBox = "Camel Case : textBox";
		// 파스칼 표기법(Pascal Case)
		// 카멜 표기법과 같으나 첫 문자가 대문자임.
		String TextBox = "Pascal Case : TextBox";
		// 스네이크 표기법(SnakeCase)
		// 단어와 단어 사이에 띄어쓰기한 공백을 _(underscore)를 붙여서 단어와 단어를 이어 표기함.
		String text_box = "Snake Case : text_box";
		// 케밥 표기법(Kebab Case)
		// 단어와 단어사이에 띄어쓰기한 공백을 -(Hyphen)을 붙여서 단어와 단어를 이어 표기함.
		// Java에서는 사용 불가능함.
		// String text-box = "Kebab Case : text-box";

		System.out.println(textBox);
		System.out.println(TextBox);
		System.out.println(text_box);
	}
}
