package com.arsyux.jblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data - @Getter, @Setter, @ToString, @EqualAndHashCode, @AllArgsConstructor 포함
// @NoArgs Constructor - 기본 생성자 생성
// @AllArgsConstructor - 모든 멤버 변수 초기화하는 생성자 생성
// @Builder - 빌더 패턴이 적용된 builder() 메소드 생성
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	// pom.xml의 Dependencies에서 Lombok 설정을 삭제했다가 셋업 후 다시 설정하였음.
	private int id;
	private String username;
	private String password;
	private String email;
	
} 