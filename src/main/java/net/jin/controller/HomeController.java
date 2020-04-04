package net.jin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "/text/about";
	}
	
	@GetMapping("/cultureBlog")
	public String cultureBlog() {
		return "/text/cultureblog";
	}
	
	@GetMapping("/foodBlog1")
	public String foodBlog() {
		return "/text/foodblog1";
	}
}
