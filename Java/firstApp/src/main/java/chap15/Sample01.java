package chap15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample01 {

	public static void main(String[] args) {
		// 표현식 (Regular Expression)
		// ^ 문자열의 시작부터
		// $ 문자열의 종료까지
		// . 줄바꿈을 제외한 임의의 한 문자
		// ? 바로 앞에 문자가 없거나 한 문자가 있을 때
		// * 바로 앞에 문자가 없거나 하나 이상 있을 때
		// + 바로 앞에 문자가 하나 이상 있을 때
		// [^] ^이후의 괄호안 형식을 제외한 문자
		// [] []안의 형식을 일치하는 문자열
		// {} {}앞 문자열의 반복 개수(예: ab{2,}(2개 이상),ab{1,2} 1부터 2까지
		// () ()안의 내용을 하나의 묶음으로 처리
		// | or연산
		// [0-9] 0부터 9까지의 숫자
		// [a-z] 영어 소문자
		// [a-zA-Z] 영어 대소문자
		// \s 모든 공백 문자
		// \S 모든 공백 문자를 제외
		// \d [0-9]와 동일
		// \D [0-0]를 제외한 문자
		// \w [0-9a-zA-Z]와 동일
		// \W [0-9a-zA-Z]를 제외한 문자
		String str1 = "1234567890";
		String str2 = "123123";
		String str3 = "123123a";
		// 숫자만 허용하는 정규식
		System.out.println(str1.matches("^[0-9]*$"));
		System.out.println(str2.matches("^[0-9]*$"));
		System.out.println(str3.matches("^[0-9]*$"));
		System.out.println();
		// 대문자와 숫자만 입력하는 6자리의 문자열
		// 먼저 전체 문자열이므로 ^와 $로 끝나야함.
		// 그리고 문자열은 숫자와 대문자이니까 [0-9A-Z]이고,
		// 6자리이니까 {6}이 됨.
		// 즉, ^[0-9A-Z]{6}$
		// 한 개의 문자만 확인하는게 아니라면 {}를 활용해서 개수를 제한해야함.
		// 아니면 *를 해서 연속 문자임을 알려줘야함.
		// 개수를 제한하지 않으면, 1개의 문자만 확인하고 true/false를 반환함.
		String[] arr = { "12AAAV", "abcd1", "ABCDEF", "ABCDE123" };
		String regex = "^[0-9A-Z]{6}$";
		for (String s : arr) {
			System.out.println(s.matches(regex));
		}
		System.out.println();

		String target = "abc@aa.com,11@12.co.kr,11aa@4d.net,a@b.com";
		regex = "([\\w]*@[\\w]*(.com))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(target);
		while (m.find()) {
			System.out.println(m.group());
		}
		System.out.println();

		regex = "([\\w]*@[\\w]*(.com|.net))";
		p = Pattern.compile(regex);
		m = p.matcher(target);
		while (m.find()) {
			System.out.println(m.group());
		}
		System.out.println();

		regex = "[^0-9]";
		for (String data : arr) {
			System.out.printf("%s \t %S\n", data, data.replaceAll(regex, ""));
		}
	}

}
