package com.arsyux.jblog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsyux.jblog.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	// JpaRepository<T, ID>에서 T는 엔티티 클래스 타입이고, ID는 엔티티 클래스에 설정한 식별자의 타입이다.
	// @Repository는 생략할 수 있다.
}