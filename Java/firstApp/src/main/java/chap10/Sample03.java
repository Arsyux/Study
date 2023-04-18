package chap10;

class Computer1 {
	// 클래스에서 제네릴을 사용하지않아서 제네릭 타입을 사용할 수 없음
	private String name;

	public void SetName(String name) {
		this.name = name;
	}

	public String GetName() {
		return this.name;
	}

	// 생성자에 제네릭 타입을 선언
	public <T extends ComputerPart> Computer1(T component) {
		this.name = component.getClass().getName();
	}
}

class ComputerPart1 {
}

class Memory1 extends ComputerPart {
}

public class Sample03 {
	public static void main(String[] args) {
		// 생성자를 통한 객체 생성(입력되는 타입이 제한됨)
		Computer1 mem = new Computer1(new Memory1());
		System.out.println(mem.GetName());
	}
}
