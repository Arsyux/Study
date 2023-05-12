package chap15_RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample04_Regular4 {

	public static void main(String[] args) {
		String str1 = "나는 소년입니다.";
		String str2 = "I am a boy";
		Pattern p = Pattern.compile("[ㄱ-ㅎ|ㅏ-ㅣ|가-힇]");
		Matcher m1 = p.matcher(str1);
		Matcher m2 = p.matcher(str2);
		
		System.out.println("[" + str1 + "] 한글이 포함되었나요? " + m1.find());
		System.out.println("[" + str2 + "] 한글이 포함되었나요? " + m2.find());
	}

}
