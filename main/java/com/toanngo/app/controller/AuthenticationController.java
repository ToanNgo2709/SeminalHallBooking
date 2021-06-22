package com.toanngo.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toanngo.app.model.Department;
import com.toanngo.app.model.UserInfo;
import com.toanngo.app.service.DepartmentService;
import com.toanngo.app.service.UserInfoService;
import com.toanngo.app.service.UserRoleService;

@Controller
public class AuthenticationController {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	UserRoleService roleService;

	@Autowired
	UserInfoService userService;

	@RequestMapping(value = "/authen/login")
	public String login() {
		return "/Authentication/login";
	}

	@RequestMapping(value = "/authen/loginDb")
	public String loginDb(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

		UserInfo userInfo = userService.GetByUsername(username);
		if (userInfo != null) {
			if (userInfo.getPassword().equals(password)) {
				session.setAttribute("username", userInfo.getUsername());
				session.setAttribute("id", userInfo.getId());
				session.setAttribute("department", userInfo.getDepartment().getName());
				if(userInfo.getUserRole().getName().equals("admin")) {
					return "redirect:/admin/booking_manage";
				}else {
					return "redirect:/";
				}				
			} else {
				System.out.println("Password not correct. Try Again");
				return "redirect:/authen/login";
			}
		} else {
			System.out.println("Account not exist, please register");
			return "redirect:/authen/register";
		}

	}
	
	@RequestMapping(value = "/authen/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/authen/login";
	}

	@RequestMapping(value = "/authen/register")
	public String register(Model model) {
		UserInfo newUser = new UserInfo();
		model.addAttribute("newUser", newUser);
		return "/Authentication/register";
	}

	@ModelAttribute(name = "departmentList")
	public List<Department> getDepartmentList() {
		return departmentService.GetAll();
	}

	@RequestMapping(value = "/authen/registerDb")
	public String registerDb(@ModelAttribute("newUser") UserInfo newUser,
			@RequestParam("rePassword") String rePassword) {

		// Check user exist
		if (userService.checkUserExist(newUser.getUsername(), newUser.getPassword())) {

			// Check password match
			if (newUser.getPassword().equals(rePassword)) {

				newUser.setUserRole(roleService.GetById(3));
				newUser.setActive(true);
				userService.Create(newUser);
				return "redirect:/authen/register";
			} else {
				System.out.println("not match");
				return "redirect:/authen/register";
			}

		} else {
			System.out.println("User exist, Try another username and email");
			return "redirect:/authen/register";
		}

	}
}
