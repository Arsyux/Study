package chap13;

import java.text.DecimalFormat;

public class Sample02 {

	public static void main(String[] args) {
		int myMoney = -5000;
		System.out.println(myMoney);
		// 숫자 형식 패턴 구문
		// 0 자릿수 항상표시(숫자의 자릿수가 작은 경우에도 0이 표시됨
		// # 숫자, 선행 0이 생략되었음
		// . 소수점 구분 기호 표시
		// , 표시 그룹 구분 기호
		// E 지수 형식에 대한 mantissa와 지수의 분리를 표시
		// ; 구분 형식
		// - 음수 접두어를 표시
		// % 100을 곱하고 숫자를 백분율로 표시
		// \u2030 1,000씩 곱하고 밀리미터 단위로 숫자를 표시
		// 예시) 0.1234를 "#.##\u2030" 형식으로 포맷팅하면 "12.34‰"로 출력
		// \u00a4는 통화 기호를 나타냄
		// 예시) 1234.56 -> "$#,##0.00" -> "$1,234.56"
		// ' 특수문자 주위에 숫자의 접두사 또는 접미사로 따옴표를 묶습니다.
		DecimalFormat df = new DecimalFormat("#,###.##"); // 소수점이 없으므로 생략
		System.out.println(df.format(myMoney));
		
		float val2 = -5000f;
		DecimalFormat df2 = new DecimalFormat("##,###,###.00");
		System.out.println(df2.format(val2));
		
		double d1 = 20;
		double d2 = -50;
		DecimalFormat df3 = new DecimalFormat("(수익)##,###,##0;(손실)##,###,##0");
		// 양수면 왼쪽, 음수면 오른쪽을 출력
		System.out.println(df3.format(d1));
		System.out.println(df3.format(d2));
	}

}
