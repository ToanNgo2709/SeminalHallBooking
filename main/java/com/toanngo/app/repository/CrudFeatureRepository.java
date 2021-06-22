package com.toanngo.app.repository;

import java.util.List;

public interface CrudFeatureRepository<Type> {
	
	public Type Create(Type model);
	public Type Update(Type model);
	public void Delete(int id);
	
	public List<Type> GetAll();
	public Type GetById(int id);
	
}
