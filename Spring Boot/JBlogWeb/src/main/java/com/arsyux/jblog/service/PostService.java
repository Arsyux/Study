package com.arsyux.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arsyux.jblog.domain.Post;
import com.arsyux.jblog.persistence.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Transactional(readOnly = true)
	public Page<Post> getPostList(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Transactional
	public void insertPost(Post post) {
		// 포스트 등록 기능에서 중요한 것은 새로운 포스트가 등록될 때 반드시 연관된 회원 엔티티가
		// Post,user 변수에 할당되어야 함.
		// 그래야 POST 테이블의 외래키인 USERID 컬럼에 회원의 ID정보가 설정되기 때문임.
		post.setCnt(0);
		postRepository.save(post);
	}

	@Transactional(readOnly = true)
	public Post getPost(int id) {
		return postRepository.findById(id).get();
	}

	@Transactional
	public void updatePost(Post post) {
		// 검색한 Post 엔티티의 title과 content를 사용자가 입력한 값으로 변경
		// 트랜잭션이 종료되면 JPA의 더티 체킹에 의해 UPDATE 구문이 작성되어 처리된다.
		// 더티체킹 : 트랜잭션이 종료되는 시점에 오염된 엔티티, 즉 값이 변경된 엔티티를 찾는 과정을 뜻한다.
		// JPA는 더티체킹으로 변경된 엔티티를 찾고, 해당 엔티티에 대한 UPDATE구문을 생성하여 SQL저장소에 등록한다.
		// 그리고 트랜잭션이 종료되는 시점에 해당 UPDATE구문을 SQL저장소에 저장된 다른 SQL구문과 함께 데이터베이스에 전송한다.
		Post findPost = postRepository.findById(post.getId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
		// updatePost()메소드에서 Post엔티티를 수정후에 save()메소드를 호출하지 않은 것은 updatePost()메소드에
		// @Transactional을 설정했기 때문임.
	}

	@Transactional
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
