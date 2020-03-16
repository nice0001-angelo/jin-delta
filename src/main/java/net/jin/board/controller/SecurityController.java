package net.jin.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/system/login")
	public void login() {
	}

	@GetMapping("/system/accessDeined")
	public void accessDenied() {
	}
	
	@GetMapping("/system/logout")
	public void logout() {
	}

	@GetMapping("/adimi/adminPage")
	public void admin() {
	}
}
