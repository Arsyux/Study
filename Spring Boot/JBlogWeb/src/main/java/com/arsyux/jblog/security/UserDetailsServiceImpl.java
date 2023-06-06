package com.arsyux.jblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.persistence.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loadUserByUsername() 메소드는 매개변수로 받은 사용자 아이디를 잉용하여
		// com.arsyux.jblog.domain.User 엔티티를 검색함
		// 그리고 검색 결과를 바탕으로 앞서 작성한 UserDetailsImpl 객체를 생성하여 반환
		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException(username + " 사용자가 없습니다.");
		});
		return new UserDetailsImpl(principal);
	}
	
}
