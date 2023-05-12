package chap04_Operator;

public class Sample01_Operator {

	public static void main(String[] args) {
		// 연산자
		int num1 = 10;
		int num2 = 5;
		// 산술 연산자
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 % num2);
		// 증감 연산자
		System.out.println(++num1);
		System.out.println(num1++);
		System.out.println(--num1);
		System.out.println(num1--);
		// 비교 연산자
		System.out.println(num1 < num2);
		System.out.println(num1 > num2);
		System.out.println(num1 <= num2);
		System.out.println(num1 >= num2);
		System.out.println(num1 == num2);
		System.out.println(num1 != num2);
		// 논리 연산자
		System.out.println(true && true);
		System.out.println(false || true);
		System.out.println(true ^ false); // XOR : 다르면 참, 같으면 거짓
		System.out.println(!false);
		// 비트 연산자
		// num1 = 10 = 00001010
		// num2 = 5 = 00000101
		System.out.println(num1 & num2); // 00000000
		System.out.println(num1 | num2); // 00001111
		System.out.println(num1 ^ num2); // 00001111
		System.out.println(~num1); // 11110101
		System.out.println(num1 << 1); // 00010100
		System.out.println(num1 >> 1); // 00000101
		// 복합대입 연산자
		num1 += 1; // 11
		num1 -= 1; // 10
		num1 *= 4; // 40
		num1 /= 2; // 20
		num1 %= 13; // 7
		num1 &= num2; // 5
		num1 |= num2; // 5
		num1 <<= 1; // 10
		num1 >>= 1; // 5
		// num1을 오른쪽으로 2비트만큼 이동하고 왼쪽의 빈 공간을 모두 0으로 채워서 num1에 대입.
		num1 >>>= 2; // 1
		num1 ^= num2; // 4
		System.out.println(num1);
		// 삼항 연산자
		int num3 = num1 < num2 ? num1 : num2;
		System.out.println(num3);
	}
}
