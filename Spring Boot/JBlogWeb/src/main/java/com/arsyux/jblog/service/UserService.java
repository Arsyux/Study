package com.arsyux.jblog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsyux.jblog.domain.RoleType;
import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.persistence.UserRepository;

@Service
public class UserService {

	// 일반적으로 컨트롤러는 서비스 클래스를 호출하고 서비스 클래스에서 리포지터리를 사용한다.
	// 이렇게 컨트롤러와 리포지터리 사이에 서비스 클래스를 추가하는 이유는
	// 하나의 서비스 클래스에서 여러 리포지터리를 이용함으로써
	// 하나의 트랜잭션으로 여러 데이터베이스 관련 작업을 처리하기 위해서다.
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
}
