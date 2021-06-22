package com.toanngo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.model.SeminarHall;

@Repository
@Component
public interface HallRepository extends JpaRepository<SeminarHall, Integer> {
	
	@Query(value = "SELECT * FROM seminar_hall WHERE active = ?1 ", nativeQuery = true)
	public List<SeminarHall> GetActiveHall(boolean active);
}
