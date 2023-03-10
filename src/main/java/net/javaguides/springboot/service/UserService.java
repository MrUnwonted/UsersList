package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUserById(long id);
//	List<User> getByKeyword(String keyword);
	List<User> listAll(String keyword);
}
