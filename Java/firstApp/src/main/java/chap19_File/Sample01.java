package chap19_File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Sample01 {

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
		
	}

}
