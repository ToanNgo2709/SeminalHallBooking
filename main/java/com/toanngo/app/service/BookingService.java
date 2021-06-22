package com.toanngo.app.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.Booking;
import com.toanngo.app.repository.BookingRepository;
import com.toanngo.app.repository.CrudFeatureRepository;

@Service
@Component
public class BookingService implements CrudFeatureRepository<Booking> {

	@Autowired
	BookingRepository repository;
	
	@Override
	public Booking Create(Booking model) {
		return repository.save(model);
	}

	@Override
	public Booking Update(Booking model) {
		Booking booking = repository.findById(model.getId()).orElse(null);
		if(booking != null) {
			booking.setFromDate(model.getFromDate());
			booking.setToDate(model.getToDate());
			booking.setSession(model.getSession());
			booking.setApprovalNumber(model.getApprovalNumber());
			booking.setApprovalDate(model.getApprovalDate());
			booking.setPurpose(model.getPurpose());
			booking.setNumberOfPerson(model.getNumberOfPerson());
			booking.setApproveStatus(model.isApproveStatus());
			repository.save(booking);
		}
		return model;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Booking> GetAll() {
		return repository.findAll();
	}

	@Override
	public Booking GetById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Booking> GetBookingListByDate(Date startDate, Date endDate, int hallId){
		return repository.getBookingListByDate(startDate, endDate, hallId);
	}
	
	public List<Booking> GetBookingByUserId(int userId){
		return repository.getBookingByUser(userId);
	}
	
}
