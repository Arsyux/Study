package chap02;

public class Sample01 {

	public static void main(String[] args) {
		// �⺻ �ڷ��� (Primitive Type)
		
		// ���� (boolean)
		boolean IsBoolean = true;
		
		// ������ (char)
		// Java������ �����ڵ带 ����Ͽ� 2byte�� �����.
		// 1����Ʈ�� ASCII Code �����ε� ǥ�� ����.
		// ���ͷ��� �� ���ڸ� �Է��� �����ϰ� ���� �յڷ� ���� ����ǥ(')�� ������.
		char IsChar = 'A';
		
		// ������
		// Byte (-128~127) signed 1Byte
		byte IsByte = 127;
		// Short (-32,768~32,767) signed 2Byte
		short IsShort = 32767;
		// Int (-2,147,483,648~2,147,483,647) signed 4Byte
		int IsInt = 2147483647;
		// IsLong signed 8Byte
		long IsLong = 1000L;
		
		// �Ǽ���
		// float
		// ��ȿ ���� : �Ҽ��� ���� 6�ڸ�
		float IsFloat = 1.234f;
		// ��ȿ ���� : �Ҽ��� ���� 15�ڸ�
		double IsDouble = 3.1415926;
		
		// ������
		// Boolean
		System.out.printf("%b\n", IsBoolean);
		// Decimal
		System.out.printf("%d\n", IsByte);
		// Octal
		System.out.printf("%o\n", IsShort);
		// Hexadecimal
		System.out.printf("%x\n", IsInt);
		System.out.printf("%X\n", IsLong);
		// �Ǽ��� 10����
		System.out.printf("%f\n", IsFloat);
		// �������� ǥ��
		System.out.printf("%e\n", IsDouble);
		// ����
		System.out.printf("%c\n", IsChar);
		// ���ڿ�
		System.out.printf("%s", "Hello, World!");
		
		// Ȯ��Ư������
		// ����
		System.out.println("\n");
		// Tab
		System.out.println("\t");
		// ĳ���� ����
		System.out.println("\r");
		// \ ǥ��
		System.out.println("\\");
		// " ǥ��
		System.out.println("\"");
		// ' ǥ��
		System.out.println("\'");
		// �齺���̽� (��ĭ ������)
		System.out.println("\b");
		// 4�ڸ��� 16������ �����ڵ带 ����Ҷ� ���
		System.out.println("\u0041");
	}
}
