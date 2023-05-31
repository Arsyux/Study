package com.arsyux.jblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JBlogWebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 블로그에 접속하는 순간 AuthenticateInterceptor 클래스의 preHandle() 메소드가 동작함
		// 세션에 사용자 정보가 없으면 무조건 로그인 화면으로 이동함.
		// 지금은 인덱스 페이지 경로에 대해서만 처리하고 있지만,
		// 인증이 필요한 경로를 계속 추가할 수 있다.
		registry.addInterceptor(new AuthenticateInterceptor()).addPathPatterns("/", "/post/**");
	}
}
