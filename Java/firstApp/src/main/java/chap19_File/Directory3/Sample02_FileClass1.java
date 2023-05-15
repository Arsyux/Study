package chap19_File;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample02_FileClass1 {

	public static void main(String[] args) {
		// File 클래스는 OS에 따라 파일 경로를 구분하는 구분자가 다름
		// UNIX는 /지만 WINDOWS는 \임
		// -> File.separator 로 해결
		String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "chap19_File";
		System.out.println("Path : " + path);

		File directory1 = new File(path + File.separator + "Directory1");
		if (!directory1.exists()) {
			if (directory1.mkdir()) {
				System.out.println("Directory1 폴더를 생성했습니다.");
			} else {
				System.out.println("Directory1 폴더 생성에 실패하였습니다.");
			}
		} else {
			System.out.println("Directory1 폴더 확인 완료");
		}

		// 모든 파일과 디렉터리 수집
		System.out.println("파일 목록 ===");
		String[] files = (new File(path)).list();
		List<String> fileList1 = new ArrayList<String>();
		for (String fn : files) {
			File f = new File(path + File.separator + fn);
			if (f.isDirectory()) {
				// 디렉터리인 경우
				fn = "디렉터리 : " + fn;
			} else {
				// 파일인 경우
				fn = "파일    : " + fn;
			}
			fileList1.add(fn);
		}
		// 순차 정렬
		fileList1.sort(Comparator.naturalOrder());
		fileList1.forEach(System.out::println);
		System.out.println("===========");

		// 파일 추가
		try (FileOutputStream fos = new FileOutputStream(path + File.separator + "testJava.txt")) {
			fos.write('J');
			fos.write('a');
			fos.write('v');
			fos.write('a');
			System.out.println("testJava.txt 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// Stream으로 표현
		System.out.println("파일 목록 ===");
		files = (new File(path)).list();
		List<String> fileList2 = Arrays.stream(files).map(x -> {
			File f = new File(path + File.separator + x);
			return f.isDirectory() ? "디렉터리 : " + x : "파일    : " + x;
		}).collect(Collectors.toList());
		// 역순 정렬
		fileList2.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("===========");

		// 파일 삭제
		files = (new File(path)).list();
		Arrays.stream(files).filter(x -> (new File(path + File.separator + x)).isFile())
				.filter(x -> x.startsWith("testJava")).map(x -> {
					(new File(path + File.separator + x)).delete();
					return x;
				}).forEach(x -> System.out.println(path + File.separator + x + "가 삭제되었습니다."));

		// Stream으로 표현
		System.out.println("파일 목록 ===");
		// 역순 정렬
		files = (new File(path)).list();
		fileList2 = Arrays.stream(files).map(x -> {
			File f = new File(path + File.separator + x);
			return f.isDirectory() ? "디렉터리 : " + x : "파일    : " + x;
		}).collect(Collectors.toList());
		fileList2.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("===========");
	}

}
