package com.toanngo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.model.Slide;

@Repository
@Component
public interface SlideRepository extends JpaRepository<Slide, Integer> {
	
	@Query(value="SELECT * FROM slide WHERE booking_id = ?1", nativeQuery = true)
	public List<Slide> GetSlideByBooking(int bookingId);
}
