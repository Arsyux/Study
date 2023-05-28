package com.arsyux.jblog.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {
	
	// 비즈니스 컴포넌트 구성
	// 비즈니스 컴포넌트를 작성하는 순서는 엔티티 -> 리포지터리 -> 서비스 순이다.
	// JPA의 연관 매핑을 사용하여 엔티티들을 연결해준다.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	// 서머노트를 적용하면 다양한 <html> 태그가 포함된다.
	@Lob
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	private int cnt;
	
	// Post 클래스에서 가장 중요한 변수는 user이며 User엔티티와의 연관매핑을 담당한다.
	// JPA는 연관매핑을 위해 다양한 어노테이션을 제공함
	// 어노테이션      다중성(multiplicity)
	// @OneToOne    1:1
	// @ManyToOne   N:1
	// @OneToMany   1:N
	// @ManyToMany  N:M
	// 포스트 관점에서 회원과의 관계는 N:1이기 떄문에 ManyToOne을 사용함.
	// FetchType.EAGER은 Post엔티티를 검색할 때 연관된 User 엔티티를 JOIN을 통해 즉시(EAGER) 조회함
	// FetchType.LAZY는 처음부터 JOIN을 사용하는 것이 아니라 실제 User 엔티티를 사용하는 시점에 늦게(LAZY) 조회한다.
	// 테이블을 연결해주고 @JoinColumn을 통해 외래키로 사용할 컬럼 이름을 지정한다. 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;
	
}
