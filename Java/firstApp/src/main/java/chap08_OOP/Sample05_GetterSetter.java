package chap08_OOP;

public class Sample05_GetterSetter {

	private int a;
	private int b;
	private int c;

	public Sample05_GetterSetter() {

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
		Sample05_GetterSetter s = new Sample05_GetterSetter();
		s.setA(1);
		s.setB(2);
		s.setC(3);
		System.out.println(s.toString());
	}
}
