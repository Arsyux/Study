package com.arsyux.jblog.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

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
	
	// 포스트의 상세 화면에서는 해당 포스트에 속한 댓글 목록도 같이 출력되어야 한다.
	// 즉, Post를 통해 Reply 정보도 조회할 수 있어야 한다.
	// 이를 위해 Post와 Reply를 1:N(일 대 다) 관계로 한번 더 매핑한다.
	// => Reply와 Post는 N:1, 1:N 관계로 양방향 매핑이 된다.
	// 데이터베이스에서는 테이블의 양방향 매핑을 하나의 외래키만 사용하여 처리한다.
	// 반면, 객체를 양방향으로 매핑하기 위해서는 관계에 참여하는 두 객체가 서로에 대한 참조변수를 가지고 있어야한다.
	// 이때, 두 참조변수 중 하나를 선택하여 연관관계의 주인으로 설정해야 하는데
	// 일반적으로 외래키 필드를 가진 엔티티를 연관관계의 주인으로 지정한다.
	// 그리고 반대쪽 객체에 연관관계의 주인이 아님을 명시하기 위해 mappedBy 속성을 설정한다.
	@OneToMany(mappedBy = "post" ,fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("id desc")
	private List<Reply> replyList;
	
}
