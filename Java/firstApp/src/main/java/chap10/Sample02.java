package chap10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 컴퓨터 내장 부품 대상 객체
class ComputerPart {
}

// 그래픽
class Graphic extends ComputerPart {
}

// 메모리
class Memory extends ComputerPart {
}

// 모니터
class Monitor {
}

// 제한된 자료형의 제네릭
// 꼭 처리할 자료형만 들어올 수 있게 하고 싶을때
@Data
@NoArgsConstructor
@AllArgsConstructor
class Computer<T extends ComputerPart> {

	private T component;

	public void toInfo() {
		System.out.println(component.getClass().getName());
	}

}

public class Sample02 {

	public static void main(String[] args) {
		Computer<ComputerPart> vga = new Computer<>();
		vga.setComponent(new Graphic());
		// ComputerPart를 상속받지 않는 객체는 제한됨.
		// vga.setComponent(new Monitor());
		vga.toInfo();

		// 생성자를 통한 객체 생성
		Computer<ComputerPart> mem = new Computer<>(new Memory());
		// ComputerPart를 상속받지 않는 객체는 제한됨.
		//Computer<ComputerPart> mem2 = new Computer<>(new Monitor());
		mem.toInfo();
	}
}
