package com.arsyux.jblog.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.arsyux.jblog.KakaoHelper;
import com.arsyux.jblog.domain.OAuthType;
import com.arsyux.jblog.domain.RoleType;
import com.arsyux.jblog.domain.User;
import com.google.gson.Gson;

@Service
public class KakaoLoginService {

	//@Value("${kakao.default.password}")
	//private String kakaoPassword;
	
	public String getAccessToken(String code) {
		// HttpHeader 생성 (MIME 종류)
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 생성 (4개의 필 수 매개 변수 설정)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type",	"authorization_code");
		body.add("client_id", KakaoHelper.id);
		body.add("redirect_uri", "http://localhost:8080/oauth/kakao");
		body.add("code", code);
		
		// HttpHeaders와 HttpBody가 설정된 HttpEntity 객체 생성
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, header);
		
		// RestTemplate를 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있음
		RestTemplate restTemplate = new RestTemplate();
		
		// HTTP 요청 및 응답받기
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, requestEntity, String.class);
		
		// HTTP 응답 본문(body) 정보 반환
		String jsonData = responseEntity.getBody();
		
		// JSON 데이터에서 액세스 토큰 정보만 추출
		Gson gsonObj = new Gson();
		Map<?, ?> data = gsonObj.fromJson(jsonData, Map.class);
		
		return (String) data.get("access_token");
	}
	
	public User getUserInfo(String accessToken) {
		// HttpHeader 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpHeader와 HttpBody를 하나의 객체에 담기(body 정보는 생략 가능)
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(header);
		
		// RestTemplate을 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있음.
		RestTemplate restTemplate = new RestTemplate();
		
		// HTTP 요청을 POST(GET) 방식으로 실행 -> 문자열로 응답이 들어옴.
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, requestEntity, String.class);
		
		// 카카오 인증 서버가 반환한 사용자 정보
		//return responseEntity.getBody();
		String userInfo = responseEntity.getBody();
		
		// JSON 데이터에서 추출한 정보로 User 객체 설정
		Gson gsonObj = new Gson();
		Map<?, ?> data = gsonObj.fromJson(userInfo, Map.class);
		
		//Double id = (Double) (data.get("id"));
		//String nickname = (String) ((Map<?, ?>) (data.get("properties"))).get("nickname");
		String email = (String) ((Map<?, ?>) (data.get("kakao_account"))).get("email");
		
		User user = new User();
		user.setUsername(email);
		user.setPassword(KakaoHelper.password);
		user.setEmail(email);
		user.setRole(RoleType.USER);
		user.setOauth(OAuthType.KAKAO);
		
		return user;
	}
	
}
