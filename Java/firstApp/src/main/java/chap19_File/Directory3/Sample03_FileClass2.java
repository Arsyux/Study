package chap19_File;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample03_FileClass2 {

	public static void main(String[] args) {

		String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "chap19_File";

		// 디렉터리는 앞뒤로 대괄호를 넣고 파일은 속성을 출력
		// 모든 파일과 디렉토리 수집
		String[] files = new File(path).list();

		// 디렉터리 filter식 작성
		Predicate<String> dirCondition = x -> {
			File fileDir = new File(path + File.separator + x);
			return fileDir.isDirectory();
		};

		// 파일 filter식 작성
		Predicate<String> fileCondition = Predicate.not(dirCondition);

		List<String> dirList = Arrays.stream(files).filter(dirCondition).map(dir -> "[" + dir + "]")
				.collect(Collectors.toList());
		List<String> fileList = Arrays.stream(files).filter(fileCondition).map(file -> {
			File f = new File(file);
			// .java파일은 제외
			file += (f.canExecute()) ? "\t실행 파일" : "\t실행 불가";
			file += (f.canRead()) ? "\t읽기 가능" : "\t읽기 불가";
			file += (f.canWrite()) ? "\t쓰기 가능" : "\t쓰기 불가";
			file += (f.isHidden()) ? "\t숨김 파일" : "\t일반 파일";
			return file;
		}).collect(Collectors.toList());

		// 글자 길이 때문에 보기 이쁘게 filter를 넣었음
		Stream.of(dirList, fileList).flatMap(List::stream).filter(x -> !x.contains(".java") && !x.contains(".png"))
				.forEach(System.out::println);
	}

}
