package chap12_enum;

public class Sample02_enum2 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Color inputColor = Color.RED;

		System.out.println(inputColor.equals(Color.RED) ? "Red" : "Not Red");
		System.out.println(inputColor.equals(Size.SMALL) ? "Red" : "Not Red");
	}

}

class Color {
	final static Color RED = new Color();
	final static Color BLUE = new Color();
	final static Color ORANGE = new Color();
}

class Size {
	final static Size SMALL = new Size();
	final static Size MIDIUM = new Size();
	final static Size LARGE = new Size();
}