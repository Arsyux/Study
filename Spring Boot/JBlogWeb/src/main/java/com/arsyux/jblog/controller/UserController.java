package com.arsyux.jblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.dto.UserDTO;
import com.arsyux.jblog.dto.ResponseDTO;
import com.arsyux.jblog.exception.JBlogException;
import com.arsyux.jblog.persistence.UserRepository;
import com.arsyux.jblog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	// REST 컨트롤러를 구현할 때는 등록 메소드에 PostMapping 어노테이션을 설정한다.
//	@PostMapping("/user")
//	public @ResponseBody String insertUser(@RequestBody User user) {
//		System.out.println("user 진입 : " + user.toString());
//		// JSON으로 전달된 회원 정보를 User 객체로 받기 위해 User 타입의 매개변수를 가진다.
//		user.setRole(RoleType.USER);
//		// userRepository를 이용하여 회원가입을 처리함.
//		// 전달된 엔티티에 식별자 값이 설정되어 있지 않으면 INSERT 기능으로 동작한다.
//		userRepository.save(user);
//		return user.getUsername() + " 회원가입 성공";
//	}

	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		// User findUser = userRepository.findById(id).get();
		// 검색된 회원이 없을 경우 JBlogException 예외 반환
		/*
		 * User findUser = userRepository.findById(id).orElseThrow(new
		 * Supplier<JBlogException>() {
		 * 
		 * @Override public JBlogException get() { return new JBlogException(id +
		 * "번 데이터가 없습니다."); } });
		 */
		// 추상 메소드가 하나만 있는 인터페이스는 람다식으로 간단하게 표현할 수 있음.
		User findUser2 = userRepository.findById(id).orElseThrow(() -> {
			return new JBlogException(id + "번 데이터가 없습니다.");
		});
		return findUser2;
	}

	// 빠른 테스트를 위해 컨트롤러 메소드에 @Transactional을 적용했지만,
	// 원래는 서비스 클래스에서 리포지터리를 호출하고 서비스 메소드에 @Transactional 어노테이션을 적용해야한다.
	@Transactional
	@PutMapping("/user")
	public @ResponseBody String updateUser(@RequestBody User user) {
		// 회원 정보 수정
		// REST 컨트롤러를 구현할 때 수정 기능의 메소드에는 @PutMapping 어노테이션을 사용함.
		// JPA는 수정 작업을 처리할 때 테이블의 모든 컬럼을 수정하는 UPDATE 구문을 사용함.
		// 이렇게 모든 컬럼 수정 원칙을 적용하면 하나의 UPDATE로 다양한 수정을 처리할 수 있기때문에 효율적임.
		User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new JBlogException(user.getId() + "번 데이터가 없습니다.");
		});
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());
		// 수정 기능을 구현할 때 save() 메소드를 호출하지 않고 메소드 위에
		// @Transactional(javax) 어노테이션을 설정해도 결과는 같음.
		// 해당 어노테이션을 사용하면 메소드가 호출될 때 트랜잭션이 시작되고,
		// 메소드가 종료되면 트랜잭션이 자동으로 종료됨.
		// 이때, COMMIT요청이 JPA 컨테이너에 전달되고
		// JPA 컨테이너는 값이 변경된 엔티티에 대한 UPDATE를 작성하여 데이터베이스에 전송함.
		// userRepository.save(findUser);
		return "데이터 수정 성공";
	}

	// 회원 삭제
	@DeleteMapping("/user/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "회원 삭제 성공";
	}

	// 회원 목록 검색
	@GetMapping("/user/list")
	public @ResponseBody List<User> getUserList() {
		return userRepository.findAll();
	}

	// 페이징 처리
	// @PageableDefault를 이용하면 PageRequest를 사용하는 것보다 쉽게 Pageable 객체를 생성할 수 있음.
	// @GetMapping("/user/page/{page}")
	@GetMapping("/user/page")
	public @ResponseBody Page<User> getUserListPaging(
			@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = { "id",
					"username" }) Pageable pageable/* @PathVariable int page */) {
		// page에 해당하는 2개의 데이터 조회
		// id와 username 내림차순 정렬
		// Pageable pageable = PageRequest.of(page, 2, Sort.Direction.DESC, "id",
		// "username");
		return userRepository.findAll(pageable);
	}

	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "user/insertUser";
	}

	// ResponseDTO<String>이 아닌 와일드 카드인 이유는 어떤 타입의 데이터가 반환될지
	// 특정할 수 없기 때문임.
	// 지금은 회원가입 성공 문자열을 반환하지만, 경우에 따라 자바 객체나 컬렉션을 반환해야할 수 있음.
	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
		// UserDTO 객체에 대한 유효성 검사
		if(bindingResult.hasErrors()) {
			// 에러가 하나라도 있다면 에러 메시지를 Map에 등록
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
		}
		
		// UserDTO -> User 객체로 변환
		User user = modelMapper.map(userDTO, User.class);
		User findUser = userService.getUser(user.getUsername());
		
		if (findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공!");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 회원입니다.");
		}
	}

}