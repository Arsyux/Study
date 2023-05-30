package com.arsyux.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arsyux.jblog.domain.Post;
import com.arsyux.jblog.persistence.PostRepository;


@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Transactional(readOnly = true)
	public List<Post> getPostList(){
		return postRepository.findAll();
	}
	
	@Transactional
	public void insertPost(Post post) {
		// 포스트 등록 기능에서 중요한 것은 새로운 포스트가 등록될 때 반드시 연관된 회원 엔티티가
		// Post,user 변수에 할당되어야 함.
		// 그래야 POST 테이블의 외래키인 USERID 컬럼에 회원의 ID정보가 설정되기 때문임.
		post.setCnt(0);
		postRepository.save(post);
	}
	
}
