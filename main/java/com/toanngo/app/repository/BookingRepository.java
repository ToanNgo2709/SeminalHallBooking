package com.toanngo.app.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.model.Booking;

@Repository
@Component
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query(value = "SELECT * FROM booking WHERE from_date >= ?1 AND to_date <= ?2 AND hall_id = ?3", nativeQuery = true)
	public List<Booking> getBookingListByDate(Date startDate, Date endDate, int hallId);
	
	@Query(value = "SELECT * FROM booking WHERE user_id = ?1", nativeQuery = true)
	public List<Booking> getBookingByUser(int userId);
}
