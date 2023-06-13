package com.arsyux.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arsyux.jblog.service.KakaoLoginService;

@Controller
public class KakaoLoginController {

	@Autowired
	private KakaoLoginService kakaoLoginService;
	
	@GetMapping("/oauth/kakao")
	public @ResponseBody String kakaoCallback(String code) {
		// 1. 인증 서버로부터 받은 CODE를 이용하여 액세스 토큰을 얻는다.
		String accessToken = kakaoCallback(code);
		
		// 2. 액세스 토큰을 이용하여 사용자 정보를 얻어온다.
		String userInfo = kakaoLoginService.getUserInfo(accessToken);
		// 응답을 콘솔과 브라우저에서 출력한다.
		//System.out.println(accessToken);
		return userInfo;
	}
	
	
	
}
