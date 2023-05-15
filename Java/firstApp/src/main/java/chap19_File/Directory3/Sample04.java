package chap19_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Sample04 {

	public static void main(String[] args) {
		// 압축하기 (Zip and Unzip)

		String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "chap19_File";
		File dirPath = new File(path + File.separator + "Directory2");
		if (!dirPath.exists()) {
			if (dirPath.mkdir()) {
				System.out.println("Directory2 폴더를 만들었습니다.");
			} else {
				System.out.println("Directory2 폴더를 만드는데 실패하였습니다.");
			}
		} else {
			System.out.println("Directory2가 있습니다.");
		}
		// 버퍼
		byte[] bytes = new byte[1024];

		// 압축할 파일 목록을 가져옴
		String[] files = new File(path).list();
		String result = "";
		try (FileOutputStream fos = new FileOutputStream(dirPath + File.separator + "test.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)) {
			Arrays.stream(files).forEach(x -> {
				File f = new File(path + File.separator + x);
				try (FileInputStream fis = new FileInputStream(f)) {
					ZipEntry zipEntry = new ZipEntry(f.getName());
					zos.putNextEntry(zipEntry);
					int length;
					while ((length = fis.read(bytes)) >= 0) {
						zos.write(bytes, 0, length);
					}
				} catch (Exception re) {
					re.fillInStackTrace();
				}
			});
			result = "압축 완료!";
		} catch (Exception e) {
			result = "에러 발생 - " + e.getMessage();
		}
		System.out.println(result);

		if (new File(dirPath + File.separator + "test.zip").exists()) {
			System.out.println("압축 성공!");
		} else {
			System.out.println("압축 실패!");
		}
	}

}
