package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.UserRole;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.UserRoleRepository;

@Service
@Component
public class UserRoleService implements CrudFeatureRepository<UserRole> {

	@Autowired
	UserRoleRepository repository;
	
	@Override
	public UserRole Create(UserRole model) {
		repository.save(model);
		return model;
	}

	@Override
	public UserRole Update(UserRole model) {
		UserRole role = repository.findById(model.getId()).orElse(null);
		if(role != null) {
			role.setName(model.getName());
			role.setActive(model.isActive());
			repository.save(role);
		}
		return role;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<UserRole> GetAll() {
		return repository.findAll();
	}

	@Override
	public UserRole GetById(int id) {
		return repository.findById(id).orElse(null);
	}

}
