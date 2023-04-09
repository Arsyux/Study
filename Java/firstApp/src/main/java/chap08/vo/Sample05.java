package chap08.vo;

public class Sample05 {

	private int a;
	private int b;
	private int c;

	public Sample05() {

	}


	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public int getC() {
		return c;
	}


	public void setC(int c) {
		this.c = c;
	}


	@Override
	public String toString() {
		return "Sample05 [a=" + a + ", b=" + b + ", c=" + c + "]";
	}


	public static void main(String[] args) {
		Sample05 s = new Sample05();
		s.setA(1);
		s.setB(2);
		s.setC(3);
		System.out.println(s.toString());
	}
}
