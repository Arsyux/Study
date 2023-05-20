package com.arsyux.jblog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	// REST(Representational State Transfer): 2000년 로이 필딩이 정의한 네트워크 소프트웨어 아키텍처
	// REST컨트롤러를 만들기 위해서는 @RestController 어노테이션을 사용함.
	// @RestController 어노테이션으로 설정된 컨트롤러는 메소드가 반환한 데이터를 자동으로 자바스크립트 객체
	// 노테이션(JavaScript Object Notation, JSON) 타입으로 변환함.
	// @RestController 클래스에 작성한 메소드에는 4가지 어노테이션이 설정되어 있으며 각 의미는 다음과 같음.
	// 요청 방식   어노테이션          의미
	// PORT      @PostMapping     등록
	// PUT       @PutMapping      수정
	// DELETE    @DeleteMapping   삭제
	// GET       @GetMapping      조회
	// http://localhost:8080/jblog 입력시 Get방식만 확인가능
	// -> 교재에서는 Postman을 사용하여 테스트하기로 함
	// https://www.postman.com/downloads/ 에 접속하여 다운로드하여 테스트
	
	// GET: SELECT
	@GetMapping("/jblog")
	public String httpGet() {
		return "GET 요청 처리";
	}

	// POST: INSERT
	@PostMapping("/jblog")
	public String httpPost() {
		return "POST 요청 처리";
	}

	// PUT: UPDATE
	@PutMapping("/jblog")
	public String httpPut() {
		return "PUT 요청 처리";
	}

	// DELETE: DELETE
	@DeleteMapping("/jblog")
	public String httpDelete() {
		return "DELETE 요청 처리";
	}

}
