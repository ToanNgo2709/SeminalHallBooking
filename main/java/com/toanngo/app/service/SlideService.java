package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.toanngo.app.model.Slide;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.SlideRepository;

public class SlideService implements CrudFeatureRepository<Slide>{

	@Autowired
	SlideRepository repository;

	@Override
	public Slide Create(Slide model) {
		return repository.save(model);
		
	}

	@Override
	public Slide Update(Slide model) {
		Slide slide = repository.findById(model.getId()).orElse(null);
		if(slide != null) {
			slide.setImagePath(model.getImagePath());
			slide.setActive(model.isActive());
			repository.save(slide);
		}
		return null;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Slide> GetAll() {
		return repository.findAll();
	}

	@Override
	public Slide GetById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Slide> GetByBooking(int bookingId){
		return repository.GetSlideByBooking(bookingId);
	}
	
	
}
