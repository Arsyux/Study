package chap15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample02 {

	public static void main(String[] args) {
		String no = "주민등록 번호 : 010101-2345879"
				  + "주민등록 번호 : 020202-4567890";
		String regex = "[0-9]{6}-[0-9]{7}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(no);
		while(m.find()) {
			System.out.print(m.group() + " -> ");
			String newNo = m.group().substring(0, 7) + "****" + m.group().substring(11);
			System.out.println(newNo);
		}
	}
	
}
