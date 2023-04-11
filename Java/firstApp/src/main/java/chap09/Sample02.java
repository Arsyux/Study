package chap09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
abstract class Pet {
	public String name;

	public abstract void Act();
}

class Cat extends Pet {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void Act() {
		System.out.println("Cat Act");
	}

	public void Run() {
		System.out.println("Cat Run");
	}
}

class Dog extends Pet {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void Act() {
		System.out.println("Dog Act");
	}
}

public class Sample02 {

	public static void main(String[] args) {
		// 업 캐스팅
		Pet p = new Cat("고양이1");
		p.Act();
		Pet c = new Cat("고양이2");
		// 다운 캐스팅 
		Cat c2 = (Cat) c;
		c2.Run();
	}
}
