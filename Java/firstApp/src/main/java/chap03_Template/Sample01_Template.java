package chap03_Template;

/**
 * <p>
 * 코드 템플릿 공부
 * </p>
 * <p>
 * Description에는 첫번째 p태그만 보임
 * </p>
 * 
 * @author Arsyux
 *
 */
public class Sample01_Template {

	/**
	 * <p>
	 * 생성자 Sample01
	 * </p>
	 * <p>
	 * 부가 설명
	 * </p>
	 */
	public Sample01_Template() {

	}

	public static void main(String[] args) {
		// 한줄 주석
		// 실무에서는 미리 코딩 스타일을 정의하여 사용함.
		// 1. 상단에 주석을 표기하는 경우
		int num = 100; // 2. 우측에 표기하는 경우
		/* 여러줄 주석 */
		/*
		 * 한 번에 여러 줄의 소스코드를 삭제하지않고 무력화시킬 떄 많이 사용함.
		 */

		// 코드 템플릿 (Code Templates)
		// Template에서 자주 사용하는 변수
		// ${date} 현재 날짜
		// ${package_name} 패키지명
		// ${enclosing_method} 메서드명
		// ${file_name} 파일명
		// ${project_name} 프로젝트명
		// ${return_type} 리턴 타입
		// ${tags} 파라미터와 리턴 타입
		// ${time} 현재 시간
		// ${type_name} 타입명
		// ${user} 시스템 계정명
		// ${year} 년도
		System.out.println(genNum(num));
	}

	/**
	 * <p>
	 * This method generates random numbers.
	 * </p>
	 * <p>
	 * 부가 설명 테스트
	 * </p>
	 * 
	 * @param Number An integer value for generating random numbers.
	 * @return Generated random value.
	 * @author Arsyux, 2023. 4. 3.
	 * @since 1.0
	 */
	public static int genNum(int Number) {
		return (int) (Math.random() * Number + 1);
	}
}
