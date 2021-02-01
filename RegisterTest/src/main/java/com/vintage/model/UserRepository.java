package com.vintage.model;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM UserInfo AS u WHERE u.email = ?1")
	User findByEmail(String email);
	
	
}
