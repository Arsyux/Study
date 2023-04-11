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
		this.color = color;
		this.manufacturer = manufacturer;
	}

	@Override
	public String fillUp() {
		return "전기";
	}
}

public class Sample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
