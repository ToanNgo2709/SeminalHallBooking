package com.toanngo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toanngo.app.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>  {
	
	@Query(value = "SELECT * FROM user_info WHERE username = ?1 or email = ?2", nativeQuery = true)
	List<UserInfo> findByUsernameEmail(String username, String email);
	
	@Query(value = "SELECT * FROM user_info WHERE username = ?1 ", nativeQuery = true)
	UserInfo findByUsername(String username);
}
