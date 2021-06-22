package com.toanngo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.model.UserAction;

@Repository
@Component
public interface UserActionRepository extends JpaRepository<UserAction, Integer> {

}
