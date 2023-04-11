package chap09;

import lombok.AllArgsConstructor;

// 추상 클래스 (Abstract Class)
@AllArgsConstructor
abstract class Car {
	protected String color;
	protected String manufacturer;

	public abstract String fillUp(); // 휘발유, 듕유, 전기등을 넣음.

	public void printInfo() {
		System.out.println("색: " + color);
		System.out.println("충전 방식: " + fillUp());
		System.out.println("제조사: " + manufacturer);
	}

	public String getColor() {
		return this.color;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}
}

class ElecCar extends Car {

	public ElecCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillUp() {
		return "전기";
	}

	public void setColor(String color) {
		this.color = color;
	}
}

class GasolCar extends Car {

	public GasolCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillUp() {
		return "휘발유";
	}
}

public class Sample01 {

	public static void main(String[] args) {
		ElecCar ec = new ElecCar("red", "현대");
		ec.setColor("white");
		ec.printInfo();
		Car c = new ElecCar("blue", "르노");
		// Car에 setColor가 없어서 사용 불가능
		// c.setColor("gray");
		c.printInfo();
		GasolCar gc = new GasolCar("black", "기아");
		gc.printInfo();
	}

}
