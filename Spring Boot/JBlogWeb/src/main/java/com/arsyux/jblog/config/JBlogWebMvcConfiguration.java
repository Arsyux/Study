package com.arsyux.jblog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebSecurity
public class JBlogWebMvcConfiguration {

	
	@Bean
	public ModelMapper modelMapper() {
		// 엔티티 vs DTO
		// 현재 엔티티 클래스를 이용하여 사용자가 입력한 값을 전달받고 있음.
		// 그러나 사용자 입력값을 받을 때는 엔티티가 아닌 DTO 클래스를 이용하는 것이 맞다.
		// JPA를 이용하여 실제 데이터베이스와 연동할 때는 엔티티를 이용함.
		// 하지만 사용자가 입력한 값을 처리하거나 검색 결과를 화면으로 전달할 때는 DTO를 사용함.
		// 즉, 일반적인 경우라면 사용자가 입력한 값을 DTO 객체를 통해 받는다.
		// 그리고 비즈니스 메소드를 호출할 때 DTO 객체에 설정된 값을 엔티티에 복사하여 인자로 전달한다.
		// 이렇게 엔티티와 DTO사이에서 멤버변수 값들을 수시로 복사하다 보면,
		// 변수가 누락되거나 개발자가 반복적으로 처리해야할 부분이 생김
		// 이러한 문제를 해결하기위해 ModelMapper라이브러리를 사용하는 것임.
		return new ModelMapper();
	}

	//@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 블로그에 접속하는 순간 AuthenticateInterceptor 클래스의 preHandle() 메소드가 동작함
		// 세션에 사용자 정보가 없으면 무조건 로그인 화면으로 이동함.
		// 지금은 인덱스 페이지 경로에 대해서만 처리하고 있지만,
		// 인증이 필요한 경로를 계속 추가할 수 있다.
		// 소스 코드 정리
		// AuthenticationInterceptor.java 삭제
		// LoginController.java 삭제
		// login.js 삭제
		//registry.addInterceptor(new AuthenticateInterceptor()).addPathPatterns("/", "/post/**");
		registry.addInterceptor(localeChaneInterceptor());
	}

	// 다국어 설정
	// 작성된 2개의 properties 메시지 파일을 모두 메모리에 로딩한 후
	// 메시지의 키를 이용하여 JSP 파일을 작성하면 브라우저의 로케일에 따라 해당하는 메시지가 제공된다.
	// 웹 애플리케이션에 다국어를 적용하기 위해서는 2가지 객체가 필요하다.
	// 첫번째는 MessageSource 객체고, 두 번째는 브라우저에서 전송한 로케일 정보를 추출하여 유지하는 LocaleResolver객체다.
	@Bean("messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message/messageSource");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}

	// 로케일 변경을 위해 인터셉터를 추가로 등록
	@Bean
	public LocaleChangeInterceptor localeChaneInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
}
