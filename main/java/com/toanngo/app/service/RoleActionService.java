package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.RoleAction;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.RoleActionRepository;

@Service
@Component
public class RoleActionService implements CrudFeatureRepository<RoleAction> {

	@Autowired
	RoleActionRepository repository;
	
	@Override
	public RoleAction Create(RoleAction model) {
		return repository.save(model);
	}

	@Override
	public RoleAction Update(RoleAction model) {
		RoleAction roleAction= repository.findById(model.getId()).orElse(null);
		if(roleAction != null) {
			roleAction.setUserAction(model.getUserAction());
			roleAction.setUserRole(model.getUserRole());
			repository.save(roleAction);
		}
		return null;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<RoleAction> GetAll() {
		return repository.findAll();
	}

	@Override
	public RoleAction GetById(int id) {
		return repository.findById(id).orElse(null);
	}
	
}
