package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.Department;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.DepartmentRepository;

@Service
@Component
public class DepartmentService implements CrudFeatureRepository<Department> {

	@Autowired
	DepartmentRepository repository;
	
	@Override
	public Department Create(Department model) {
		return repository.save(model);
	}

	@Override
	public Department Update(Department model) {
		Department department = repository.findById(model.getId()).orElse(null);
		if(department != null) {
			department.setName(model.getName());
			department.setActive(model.isActive());
			repository.save(department);
		}
		return model;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Department> GetAll() {
		return repository.findAll();
	}

	@Override
	public Department GetById(int id) {
		return repository.findById(id).orElse(null);
	}

}
