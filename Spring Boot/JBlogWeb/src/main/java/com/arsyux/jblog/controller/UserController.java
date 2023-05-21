package com.arsyux.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arsyux.jblog.domain.RoleType;
import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.persistence.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// REST 컨트롤러를 구현할 때는 등록 메소드에 PostMapping 어노테이션을 설정한다.
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		System.out.println("user 진입 : " + user.toString());
		// JSON으로 전달된 회원 정보를 User 객체로 받기 위해 User 타입의 매개변수를 가진다.
		user.setRole(RoleType.USER);
		// userRepository를 이용하여 회원가입을 처리함.
		// 전달된 엔티티에 식별자 값이 설정되어 있지 않으면 INSERT 기능으로 동작한다.
		userRepository.save(user);
		return user.getUsername() + " 회원가입 성공";
	}
	
}