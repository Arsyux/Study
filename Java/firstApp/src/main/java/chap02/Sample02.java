package chap02;

public class Sample02 {

	public static void main(String[] args) {
		// ��⺻�ڷ��� (Non-Primitive Type)
		// new Ű���带 �̿��ؼ� ������.
		// ��� ��⺻�ڷ����� �⺻ ���� Null��.
		// ���� ���� �ƴ� ��ü�� �ּҸ� ������ �ִ� �ڷ������� ���� ��ü�� �ּҿ� ���ؼ� �����ϴ� �ڷ�����.
		String fruit = "Apple";
		System.out.println(fruit);
		System.out.println(fruit.toUpperCase());
		System.out.println(fruit.toLowerCase());

		// ������ ���� ��� str2 ���� ����� �޸𸮿� "Hello"�� �ִ��� ã��,
		// ���� ��� �ش� �޸� �ּҸ� str2�� �����ϰ� ��.
		// �� ������ �޸� �ּҰ� ������ Ȯ���� �� ����.
		String str1 = "Hello";
		String str2 = "Hello";
		// str1�� �޸� �ּҰ� ����Ǵ� ���� Ȯ�� �� �� ����.
		str1 = "Bye";
		System.out.println(str1 + ", " + str2);
		// �׿� ���� �⺻ �ڷ����� ��� �ּҰ� �����ʰ� ������ ���� ��.
		int int1 = 10;
		int int2 = 10;
		System.out.println(int1 + ", " + int2);
	}
}
