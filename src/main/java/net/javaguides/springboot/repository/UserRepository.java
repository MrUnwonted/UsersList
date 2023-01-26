package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	 //Custom query
	 @Query(value = "select * from demo.user s where s.first_name like '%:keyword%'", nativeQuery = true)
	 List<User> findByKeyword(@Param("keyword") String keyword);
}
