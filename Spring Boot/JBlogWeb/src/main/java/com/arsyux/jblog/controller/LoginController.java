package com.arsyux.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.dto.ResponseDTO;
import com.arsyux.jblog.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/auth/login")
	public String Login() {
		return "system/login";
	}

	@PostMapping("/auth/login")
	public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		System.out.println("Auth/Login!");
		User findUser = userService.getUser(user.getUsername());

		// 검색 결과 유무와 사용자가 입력한 비밀번호가 유효한지 확인
		if (findUser.getUsername() == null) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "아이디가 존재하지 않습니다.");
		} else {
			if (user.getPassword().equals(findUser.getPassword())) {
				// 로그인 성공 시 세션에 사용자 정보 저장
				session.setAttribute("principal", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "님 로그인 성공하셨습니다.");
			} else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 오류입니다.");
			}
		}
	}

	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
