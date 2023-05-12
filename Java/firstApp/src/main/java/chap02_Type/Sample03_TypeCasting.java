package chap02_Type;

public class Sample03_TypeCasting {

	public static void main(String[] args) {
		// 형 변환 (Type Casting)
		// 묵시적 형변환 (자동 형변환)
		int i1 = 100;
		double d = i1;
		System.out.println(d);
		// 명시적 형변환 (강제 형변환)
		byte b = (byte) i1;
		System.out.println(b);
		// 문자열과 숫자 자료형 형 변환
		String str = "1234";
		int num = Integer.parseInt(str);
		System.out.println(num);
		float num2 = 5678.1234f;
		String str2 = Float.toString(num2);
		String str3 = String.valueOf(num2);
		String str4 = num2 + "";
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		// 문자와 문자열 간의 형변환
		String s1 = "abcd";
		char[] arr_c = s1.toCharArray();
		for (int i = 0; i < arr_c.length; i++) {
			System.out.print(arr_c[i]);
		}
		System.out.println();
		String s2 = String.valueOf(arr_c);
		System.out.println(s2);
	}

}
