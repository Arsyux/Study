package chap10;

public class Sample05 {
	public static void main(String[] args) {
		Data d = new Data();
		d.setValue(3);
		System.out.println(d.getValue());
	}
}

class Data {
	String value;
	
	// 제네릭 메서드
	public <T> void setValue(T t) {
		this.value = t.toString();
	}
	
	public String getValue() {
		return this.value;
	}
}