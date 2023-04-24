package chap10;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Sample08 {

	public static void main(String[] args) {
		Group<Pet> petGroup = new Group<>();
		petGroup.add(new Pet("앵무새"));
		petGroup.add(new Pet("십자매"));
		Group<Wild> wildGroup = new Group<>();
		wildGroup.add(new Wild("까치"));
		wildGroup.add(new Wild("비둘기"));

		System.out.println("애완조 ===");
		getAnimalList(petGroup);
		System.out.println("--");
		getPetList(petGroup);
		System.out.println("야생조 ===");
		getAnimalList(wildGroup);
		// 불가능
		// System.out.println("--");
		// getPetList(wildGroup);
	}

	/**
	 * 상위 클래스 제한
	 * 
	 * @param group
	 */
	public static void getAnimalList(Group<? extends Animal> group) {
		Object[] g = group.getGroup();
		for (int i = 0; i < g.length; i++) {
			Animal animal = (Animal) g[i];
			System.out.println(animal.getName());
		}
	}

	/**
	 * 하위 클래스 제한
	 * 
	 * @param group
	 */
	public static void getPetList(Group<? super Pet> group) {
		Object[] g = group.getGroup();
		for (int i = 0; i < g.length; i++) {
			Pet pet = (Pet) g[i];
			System.out.println(pet.getName());
		}
	}
}

class Group<G> {
	private int listCount = 0;
	// 배열의 경우 Sub가 Super의 하위 타입일때 Sub[]은 Super[]의 하위 타입이 됨.
	// 이런 경우를 공변하다고 함.
	// 반면 제네릭 타입의 경우 Sub가 Super의 하위 타입이어도 ArrayList<Sub>는 ArrayList<Super>의 하위 타입이 아님.
	// 이런 경우를 불공변하다고 함.
	// 제네릭은 불공변하기 때문에 제네릭으로 객체를 생성하는건 불가능함.
	private G[] group = (G[]) new Object[listCount];

	public void add(G g) {
		group = Arrays.copyOf(group, ++listCount);
		group[listCount - 1] = g;
	}

	public G[] getGroup() {
		return group;
	}
}

@AllArgsConstructor
@Getter
class Animal {
	private String name;
}

class Pet extends Animal {
	public Pet(String name) {
		super(name);
	}
}

class Wild extends Animal {
	public Wild(String name) {
		super(name);
	}
}