package com.toanngo.app.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toanngo.app.model.SeminarHall;
import com.toanngo.app.service.HallService;

@Controller
public class HomeController {
	
	@Autowired
	HallService hallService;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		List<SeminarHall> hallList = hallService.GetAll();
		model.addAttribute("hallList", hallList);
		return "/ClientPage/index";
	}
	
	@RequestMapping("/filterHall")
	public String filterHall(@RequestParam("fromDate") Date fromDate, @RequestParam("toDate") Date toDate, Model model) {
		Date test1 = fromDate;
		Date test2 = toDate;
		
		return "/ClientPage/index";
	}
}
