package com.arsyux.jblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class JBlogWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void passwordEncode() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "abc123@@";
		// BCrytPasswordEncoder가 제공하는 메소드중 encode()메소드가 암호화 처리의 핵심임.
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println("암호화 전 비밀번호: " + rawPassword);
		System.out.println("암호화 이후 비밀번호: " + encodedPassword);
		System.out.println("비밀번호 비교: " + encoder.matches(rawPassword, encodedPassword));

	}

}
