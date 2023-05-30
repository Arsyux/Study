package com.arsyux.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arsyux.jblog.domain.Post;
import com.arsyux.jblog.domain.User;
import com.arsyux.jblog.dto.ResponseDTO;
import com.arsyux.jblog.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping({ "", "/" })
	public String getPostList(Model model) {
		model.addAttribute("postList", postService.getPostList());
		return "index";
	}

	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}

	@PostMapping("/post")
	public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post, HttpSession session) {
		// 세션에 있는 User 정보를 넣는다.
		User principal = (User) session.getAttribute("principal");
		if (principal.getUsername() == null) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "잘못된 접근입니다.");
		}
		post.setUser(principal);
		post.setCnt(0);
		postService.insertPost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록했습니다.");
	}

}
