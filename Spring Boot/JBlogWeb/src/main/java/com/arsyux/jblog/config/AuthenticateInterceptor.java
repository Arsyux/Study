package com.arsyux.jblog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.arsyux.jblog.domain.User;

public class AuthenticateInterceptor implements HandlerInterceptor {

	// 인터셉터 적용
	// 인터셉터는 디스패처서블릿(Dispatcherservlet)과 컨트롤러 사이에 위치하며,
	// 이를 통해 컨트롤러 실행 전/후의 사전 처리와 사후 처리 로직을 추가할 수 있다.
	// 즉, 서블릿에서의 필터(Filter)처럼 컨트롤러의 요청을 가로채는 개념이다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에 회원 정보가 존재하는지 확인
		HttpSession session = request.getSession();

		User principal = (User) session.getAttribute("principal");
		if (principal == null) {
			// 세션에 principal이라는 이름의 사용자 정보가 없으면
			// 다시 로그인 화면으로 이동하도록 preHandle() 메소드를 구현하였음.
			response.sendRedirect("/auth/login");
		}
		return true;
	}
}
