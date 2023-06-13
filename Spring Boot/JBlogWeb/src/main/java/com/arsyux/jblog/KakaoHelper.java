package com.arsyux.jblog;

import java.io.FileInputStream;

public class KakaoHelper {

	public static String id = "";
	public static String password = "";
	
	public KakaoHelper() {
		id = "";
		password = "";
		try (FileInputStream fis = new FileInputStream("C:\\DEV\\KakaoData.txt")) {
			int i;
			while ((i = fis.read()) > -1) {
				if((char)i == '\n') {
					id = id.replace("\r", "");
					break;
				}
				id += (char)i;
			}
			System.out.print(id);
			while ((i = fis.read()) > -1) {
				password += (char)i;
			}
			System.out.print(password);
		} catch (Exception e) {
			System.out.println("오류 발생 - " + e.getMessage());
		}
	}
	
}
