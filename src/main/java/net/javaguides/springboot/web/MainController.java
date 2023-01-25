package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.service.UserService;

@Controller
public class MainController {
	
	
	@Autowired
	private UserService userService;
	
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
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "index";
	}
}
