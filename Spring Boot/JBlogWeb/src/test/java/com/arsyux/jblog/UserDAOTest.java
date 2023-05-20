package com.arsyux.jblog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.persistence.UserDAO;

@SpringBootTest
class UserDAOTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	void getUserListTest() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("1234");
		user.setEmail("test@xxxxx.xxx");
		
		int before = userDAO.getUserList().size();
		userDAO.insertUser(user);
		int after = userDAO.getUserList().size();
		// 단정 메소드 (assertEquals)
		// 테스트케이스의 수행 결과를 판별함.
		assertEquals(before + 1, after);
	}
}
