package com.arsyux.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	@GetMapping({ "", "/" })
	public String getPostList() {
		return "index";
	}

	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}

}
