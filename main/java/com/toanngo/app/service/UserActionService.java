package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.UserAction;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.UserActionRepository;

@Service
@Component
public class UserActionService implements CrudFeatureRepository<UserAction> {

	@Autowired
	UserActionRepository repository;
	
	@Override
	public UserAction Create(UserAction model) {
		return repository.save(model);
	}

	@Override
	public UserAction Update(UserAction model) {
		UserAction userAction = repository.findById(model.getId()).orElse(null);
		if(userAction != null) {
			userAction.setActionLink(model.getActionLink());
			userAction.setActionUrl(model.getActionUrl());
		}
		return null;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<UserAction> GetAll() {
		return repository.findAll();
	}

	@Override
	public UserAction GetById(int id) {
		return repository.findById(id).orElse(null);
	}

}
