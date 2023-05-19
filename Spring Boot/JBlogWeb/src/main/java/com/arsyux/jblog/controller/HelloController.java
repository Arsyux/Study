package com.arsyux.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/html")
	public String html() {
		// http://localhost:8080/html 입력시 이쪽으로 매핑됨
		System.out.println("HTML파일이 요청됨");
		return "redirect:hello.html";
	}

	@GetMapping("/image")
	public String image() {
		// http://localhost:8080/image 입력시 이쪽으로 매핑됨
		System.out.println("이미지 파일이 요청됨");
		return "redirect:image/Cat.png";
	}
}
