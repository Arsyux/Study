package chap12_enum;

public class Sample03_enum3 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Color1 inputColor = Color1.RED;
		System.out.println(inputColor.equals(Color1.RED) ? "Red" : "Not Red");
		System.out.println(inputColor.equals(Size1.SMALL) ? "Red" : "Not Red");

		System.out.printf("A씨가 %s의 %s티를 입고 있습니다.", Size2.LARGE, Color2.ORANGE);
	}

}

// 단순한 열거형
enum Color1 {
	RED, BLUE, ORANGE;
}

enum Size1 {
	SMALL, MIDIUM, LARGE;
}

// 반환 값을 변경하는 상수 등록
enum Color2 {
	RED {
		@Override
		public String toString() {
			return "빨간색";
		}
	},
	BLUE {
		@Override
		public String toString() {
			return "파란색";
		}
	},
	ORANGE {
		@Override
		public String toString() {
			return "주황색";
		}
	};
}

enum Size2 {
	SMALL {
		@Override
		public String toString() {
			return "작은 사이즈";
		}
	},
	MIDIUM {
		@Override
		public String toString() {
			return "중간 사이즈";
		}
	},
	LARGE {
		@Override
		public String toString() {
			return "큰 사이즈";
		}
	}
}