package com.arsyux.jblog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arsyux.jblog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
