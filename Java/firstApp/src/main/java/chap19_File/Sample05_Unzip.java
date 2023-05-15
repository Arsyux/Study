package chap19_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Sample05_Unzip {

	public static void main(String[] args) {
		// 압축 해제 (Unzip)
		String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "chap19_File";
		File dirPath = new File(path + File.separator + "Directory3");
		if (!dirPath.exists()) {
			if (dirPath.mkdir()) {
				System.out.println("Directory3 폴더를 만들었습니다.");
			} else {
				System.out.println("Directory3 폴더를 만드는데 실패하였습니다.");
			}
		} else {
			System.out.println("Directory3가 있습니다.");
		}

		try (ZipInputStream zis = new ZipInputStream(
				new FileInputStream(path + File.separator + "Directory2" + File.separator + "test.zip"))) {
			ZipEntry zipentry = null;
			while ((zipentry = zis.getNextEntry()) != null) {
				try (FileOutputStream fos = new FileOutputStream(dirPath + File.separator + zipentry.getName())) {
					byte[] bytes = new byte[1024];
					int length;
					while ((length = zis.read(bytes)) != -1) {
						fos.write(bytes, 0, length);
					}
				}
			}
			System.out.println("압축 해제 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}
	}

}
