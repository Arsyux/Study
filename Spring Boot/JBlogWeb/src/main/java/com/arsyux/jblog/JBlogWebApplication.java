package com.arsyux.jblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JBlogWebApplication {

	public static void main(String[] args) {

		System.out.println("카카오 데이터 로드중...");
		KakaoHelper.LoadData();
		
		if (!KakaoHelper.id.equals("")) {
			SpringApplication.run(JBlogWebApplication.class, args);
		} else {
			System.out.println("카카오 데이터 로드중 에러 발생!");
		}
	}

}
