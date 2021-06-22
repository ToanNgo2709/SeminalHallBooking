package com.toanngo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toanngo.app.model.UserRole;
import com.toanngo.app.service.UserRoleService;

@Controller
public class UserRoleControlle {
	
	@Autowired
	UserRoleService service;
	
	@RequestMapping(value = "/UserRole/")
	public String allRole(Model model) {
		List<UserRole> roleList = service.GetAll();
		model.addAttribute("roleList", roleList);
		return "/UserRole/allRole";
	}
	
	
}
