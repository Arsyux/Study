package com.arsyux.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/jsp")
	public String jsp(Model model) {
		// 원래 스프링 부트에서 동적 콘텐츠의 위치는 src/main/resources/templates 폴더임.
		// jsp는 스프링 부트에서 지원하는 템플릿이 아니므로 jsp를 위한 별도의 폴더 구조를 만들어야함.
		// src/main에 webapp/WEB-INF/jblog 폴더를 생성한 후 jsp파일을 작성함.
		System.out.println("JSP 파일이 요청됨");
		model.addAttribute("username", "Arsyux");
		return "hello";
	}
}
