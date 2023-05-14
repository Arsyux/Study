package chap19_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;

public class Sample01_FileIO {

	public static void main(String[] args) {

		String path = "src/main/java/chap19_File";

		// 파일 입출력
		// 파일 쓸 때 - FileOutputStream
		// 파일 읽을 때 - FileInputStream
		try (FileInputStream fis = new FileInputStream("pom.xml");
				FileOutputStream fos = new FileOutputStream(path + "/test_pom.xml")) {
			int i;
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
			System.out.println("test_pom 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		char J = 74;
		char a = 97;
		char v = 118;
		try (FileOutputStream fos = new FileOutputStream(path + "/java.file")) {
			// 영문은 한 글자가 1byte
			fos.write(J);
			fos.write(a);
			fos.write(v);
			fos.write(a);
			fos.write(64);
			System.out.println("java.file 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		try (FileInputStream fis = new FileInputStream(path + "/Hangul.txt");
				FileOutputStream fos = new FileOutputStream(path + "/Hangul2.txt")) {
			// 한글은 한 글자가 3byte
			// => 바이트가 아닌 문자 단위로 읽고 쓰는 클래스가 필요
			fos.write(fis.read());
			fos.write(fis.read());
			fos.write(fis.read());
			System.out.println("Hangul2.txt 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// 문자단위로 읽는 클래스 FileReader
		// 문자단위로 쓰는 클래스 FileWriter
		try (FileReader fr = new FileReader(path + "/Hangul.txt");
				FileWriter fw = new FileWriter(path + "/Hangul3.txt")) {
			int i;
			while ((i = fr.read()) != -1) {
				fw.write(i);
			}
			System.out.println("Hangul3.txt 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// 문자열을 읽어서 파일로 출력하는 프로그램
		// InputStream
		// 다음과 같은 순서대로 처리됨
		// String -> ByteArrayInputStream -> InputStream -> FileOutputStream -> File
		String str = "Hello, Arsyux!";
		try (FileOutputStream fos = new FileOutputStream(path + "/Hangul4.txt");
				InputStream is = new ByteArrayInputStream(str.getBytes())) {
			int i;
			while ((i = is.read()) > -1) {
				fos.write(i);
			}
			System.out.println("Hangul4.txt 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}

		// 용량이 큰 음악 파일이나 동영상 파일은 1byte씩 단순하게 처리하는 방법으로는 오래걸릴 수 있음.
		// 1byte가 아닌 블록 단위로 읽어 속도를 향상시킬 수 있음.
		// 버퍼를 이용하는 파일 스트림으로는 BufferedInputStream 클래스와 BufferedOutputStream클래스가 있음.
		// 사용하는 방법은 아래와 같음
		// FileInputStream -> BufferedInputStream -> BufferedInputStream ->
		// FileInputStream
		try (FileInputStream fis = new FileInputStream(path + "/catImage.png");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(path + "/testCatImage.png");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			// 스트림은 기본 스트림과 필터 스트림으로 나뉘는데
			// 기본 스트림은 입력과 출력을 직접하는 스트림을 말하고, 필터 스트림은 기본 스트림을 활용하여 입력과 출력을 하는 스트림을 말함
			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			System.out.println("testCatImage.png 생성 완료!");
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}
	}

}
