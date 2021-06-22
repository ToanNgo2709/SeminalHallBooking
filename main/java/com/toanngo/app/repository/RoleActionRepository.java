package com.toanngo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.model.RoleAction;

@Repository
@Component
public interface RoleActionRepository extends JpaRepository<RoleAction, Integer> {
	
}
