package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	 //Custom query
	 @Query(value = "select * from demo.user s where s.first_name like '%?1%'", nativeQuery = true)
//	 List<User> findByKeyword(@Param("keyword") String keyword);
//	 @Query("SELECT first_name FROM user p WHERE p.first_name LIKE %?1%")
//	            + " OR p.brand LIKE %?1%"
//	            + " OR p.madein LIKE %?1%"
//	            + " OR CONCAT(p.price, '') LIKE %?1%")
	    public List<User> search(String keyword);
}
