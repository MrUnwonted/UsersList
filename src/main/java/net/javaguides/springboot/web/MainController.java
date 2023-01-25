package net.javaguides.springboot.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
//		return "login";
		 System.out.println("Hi");
		   org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		   
		   if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
		   
		   return "login";
		   }
		   else {
			   return "redirect:/";
		   }
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
