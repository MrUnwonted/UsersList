package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.User;
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
	
//	 @GetMapping("/")
//	public String viewHomePage(Model model) {
//		model.addAttribute("listUsers", userService.getAllUsers());
//		return "index";
//	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
//		create model attribute to bind form data
		User user = new User(); 
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
//		get user from the service
		User user = userService.getUserById(id);
		
//		set user as a model attribute to pre-populate the form
		model.addAttribute("user", user);
		
		return "update_user";
		
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") long id)  {
//		call delete user method
		this.userService.deleteUserById(id);
		return "redirect:/";
	}
	
	 @GetMapping({"/", "/search"})
	 public String home(User user, Model model, String keyword) {
		 System.out.println(keyword);
	  if(keyword!=null) {
		  List<User> list = userService.getByKeyword(keyword);
		   model.addAttribute("listUsers", list);
	  }else {
		  List<User> list = userService.getAllUsers();
		  model.addAttribute("listUsers", list);
	  }
	  return "index";
	 }
}
