package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.SeminarHall;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.HallRepository;

@Service
@Component
public class HallService implements CrudFeatureRepository<SeminarHall> {
	
	@Autowired
	HallRepository repository;

	@Override
	public SeminarHall Create(SeminarHall model) {
		return repository.save(model);
	}

	@Override
	public SeminarHall Update(SeminarHall model) {
		SeminarHall hall = repository.findById(model.getId()).orElse(null);
		if(hall != null) {
			hall.setActive(model.isActive());
			hall.setCapacity(model.getCapacity());
			hall.setInchare(model.getInchare());
			hall.setName(model.getName());
			repository.save(hall);
		}
		return model;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<SeminarHall> GetAll() {
		return repository.findAll();
	}
	
	public List<SeminarHall> GetActive(boolean active){
		return repository.GetActiveHall(active);
	}

	@Override
	public SeminarHall GetById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	
}
