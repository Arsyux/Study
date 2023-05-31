package com.arsyux.jblog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arsyux.jblog.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
