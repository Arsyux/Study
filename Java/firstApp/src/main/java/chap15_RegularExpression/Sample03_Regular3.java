package chap15_RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample03_Regular3 {

	public static void main(String[] args) {
		String str =  "닭아 닭아 우지 마라 네가 울면 날이 새고 날이 새면 나 죽는다.";
		String ret = "";
		int startIdx = 0;
		Pattern p = Pattern.compile("새");
		Matcher m = p.matcher(str);
		
		while(m.find()) {
			ret += str.substring(startIdx, m.start()) + "["+m.group()+"]";
			startIdx = m.end(); // 마지막 문자열 위치를 기억
		}
		
		// 마지막 검색 이후의 문자열을 더함
		if(startIdx < str.length()) {
			ret += str.substring(startIdx);
		}
		System.out.println(str);
		System.out.println(ret);
	}

}
