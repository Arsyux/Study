package chap02;

public class Sample01 {

	public static void main(String[] args) {
		// 기본 자료형 (Primitive Type)
		
		// 논리형 (boolean)
		boolean IsBoolean = true;
		
		// 문자형 (char)
		// Java에서는 유니코드를 사용하여 2byte를 사용함.
		// 1바이트의 ASCII Code 값으로도 표현 가능.
		// 리터럴은 한 문자만 입력이 가능하고 문자 앞뒤로 작은 따옴표(')로 구분함.
		char IsChar = 'A';
		
		// 정수형
		// Byte (-128~127) signed 1Byte
		byte IsByte = 127;
		// Short (-32,768~32,767) signed 2Byte
		short IsShort = 32767;
		// Int (-2,147,483,648~2,147,483,647) signed 4Byte
		int IsInt = 2147483647;
		// IsLong signed 8Byte
		long IsLong = 1000L;
		
		// 실수형
		// float
		// 유효 숫자 : 소수점 이하 6자리
		float IsFloat = 1.234f;
		// 유효 숫자 : 소수점 이하 15자리
		double IsDouble = 3.1415926;
		
		// 지시자
		// Boolean
		System.out.printf("%b\n", IsBoolean);
		// Decimal
		System.out.printf("%d\n", IsByte);
		// Octal
		System.out.printf("%o\n", IsShort);
		// Hexadecimal
		System.out.printf("%x\n", IsInt);
		System.out.printf("%X\n", IsLong);
		// 실수형 10진수
		System.out.printf("%f\n", IsFloat);
		// 지수형태 표현
		System.out.printf("%e\n", IsDouble);
		// 문자
		System.out.printf("%c\n", IsChar);
		// 문자열
		System.out.printf("%s", "Hello, World!");
		
		// 확장특수문자
		// 개행
		System.out.println("\n");
		// Tab
		System.out.println("\t");
		// 캐리지 리턴
		System.out.println("\r");
		// \ 표시
		System.out.println("\\");
		// " 표시
		System.out.println("\"");
		// ' 표시
		System.out.println("\'");
		// 백스페이스 (한칸 앞으로)
		System.out.println("\b");
		// 4자리의 16진수로 유니코드를 출력할때 사용
		System.out.println("\u0041");
	}
}
