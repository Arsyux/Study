package com.arsyux.jblog.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoLoginService {

	public String getAccessToken(String code) {
		// HttpHeader 생성 (MIME 종류)
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 생성 (4개의 필 수 매개 변수 설정)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type",	"authorization_code");
		body.add("client_id", "213bb394e5eeabe54b08ba69c3f84648");
		body.add("redirect_uri", "http://localhost:8080/oauth/kakao");
		body.add("code", code);
		
		// HttpHeaders와 HttpBody가 설정된 HttpEntity 객체 생성
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, header);
		
		// RestTemplate를 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있음
		RestTemplate restTemplate = new RestTemplate();
		
		// HTTP 요청 및 응답받기
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, requestEntity, String.class);
		
		return responseEntity.getBody();
	}
	
}
