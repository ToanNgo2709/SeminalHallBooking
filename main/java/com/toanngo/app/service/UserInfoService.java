package com.toanngo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.model.UserInfo;
import com.toanngo.app.repository.CrudFeatureRepository;
import com.toanngo.app.repository.UserInfoRepository;

@Service
@Component
public class UserInfoService implements CrudFeatureRepository<UserInfo> {

	@Autowired
	UserInfoRepository repository;
	
	@Override
	public UserInfo Create(UserInfo model) {
		return repository.save(model);
	}

	@Override
	public UserInfo Update(UserInfo model) {
		UserInfo userInfo = repository.findById(model.getId()).orElse(null);
		if(userInfo != null) {
			userInfo.setActive(model.isActive());
			userInfo.setDepartment(model.getDepartment());
			userInfo.setEmail(model.getEmail());
			userInfo.setPassword(model.getPassword());
			userInfo.setPhone(model.getPhone());
			userInfo.setUsername(model.getUsername());
			userInfo.setUserRole(model.getUserRole());
			repository.save(userInfo);
		}
		return userInfo;
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);	
	}

	@Override
	public List<UserInfo> GetAll() {
		return repository.findAll();
	}

	@Override
	public UserInfo GetById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	public UserInfo GetByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public boolean checkUserExist(String username, String email) {
		List<UserInfo> userList = repository.findByUsernameEmail(username, email);
		if(userList.size() > 0) {
			return false;
		}
		return true;
	}

}
