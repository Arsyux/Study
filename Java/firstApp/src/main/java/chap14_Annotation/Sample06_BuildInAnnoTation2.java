package chap14_Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Sample06_BuildInAnnoTation2 {

	public static void main(String[] args) throws Exception {
		Validator checker = new Validator();
		Score score = new Score("ABCDEF", 1, 20, 30, 100);
		checker.excute(score);
	}

}

// 커스텀 애너테이션
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
	int value() default 0;
}

@Getter
@Setter
@AllArgsConstructor
class Score {
	//@MaxLength(value = 5)
	@MaxLength(5)
	public String name;
	public int no;
	public int korean;
	public int english;
	public int math;
}

class Validator {
	public void excute(Score score) throws Exception {
		Field[] fields = score.getClass().getFields();
		for (Field field : fields) {
			// MaxLength 애너테이션이 있는지 확인
			if (field.isAnnotationPresent(MaxLength.class)) {
				MaxLength anno = field.getAnnotation(MaxLength.class);
				int AnnoMax = anno.value();
				int NameMax = field.get(score).toString().length();
				if (NameMax > AnnoMax) {
					System.out.printf("%s 필드의 최대 글자수는 %d자 입니다. 입력한 문자[%s]\n", field.getName(), AnnoMax,
							field.get(score).toString());
				}
			}
		}
	}
}