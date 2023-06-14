package com.arsyux.jblog.config;                                               

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.arsyux.jblog.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class JBlogWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// 사용자가 입력한 username으로 사용자 인증하는 객체
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	// BCryptPasswordEncoder 객체를 생성하는 메소드를 추가
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// @EnableWebSecurity
	// 해당 설정 적용시 WebSecurityEnablerConfiguration이라는 자동 설정 클래스는 더이상 동작하지 않음.
	// => 사용자가 원하는 방향으로 시큐리티를 커스터마이징 할 수 있음.
	
	// WebSecurityConfigurerAdapter 상속
	// 환경 설정 클래스가 @EnableWebSecurity를 가지고 WebSecurityConfigurerAdapter 클래스를 상속하면
	// 자동설정 클래스에 의해 제공되던 시큐리티 관련 객체들이 더 이상 제공되지 않음.
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 인증 없이 접근을 허용하는 경로
		http.authorizeRequests().antMatchers("/webjars/**", "/js/**", "/image/**", "/", "/auth/**", "/oauth/**").permitAll();
		
		// 나머지 경로는 인증이 필요함. => 403 에러 발생
		http.authorizeRequests().anyRequest().authenticated();
		
		// CSRF 토큰을 받지 않음
		http.csrf().disable();
		
		// 기본 로그인 화면 제공
		http.formLogin().loginPage("/auth/login");
		
		// 로그인 요청 URI를 변경함
		http.formLogin().loginProcessingUrl("/auth/securitylogin");
		
		// 로그아웃 설정
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// AuthenticationManagerBuilder가 AuthenticationManager를 생성할 때
		// UserDetailsService를 이용하도록 설정
		// 이제부터 로그인이 필요한 경우 USERS 테이블에 등록된 회원 정보를 이용
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
