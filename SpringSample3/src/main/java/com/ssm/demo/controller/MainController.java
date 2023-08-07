package com.ssm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssm.demo.entity.User;
import com.ssm.demo.form.AddForm;
import com.ssm.demo.form.SearchForm;
import com.ssm.demo.service.InfoService;

@Controller
public class MainController {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("start")
	public String view1(SearchForm searchForm,Model model) {
		
		List<User> userList = infoService.getAllUser();
		
		model.addAttribute("userList", userList);
		return "info";
	}
	
	@PostMapping("search")
	public String search(SearchForm searchForm,Model model) {
		
		List<User> userList = infoService.searhUser(searchForm);
		
		model.addAttribute("userList", userList);
		return "info";
	}
	
	
	@GetMapping("add")
	public String view2(AddForm addForm) {
		return "register";
	}
	
	@PostMapping("insert")
	public String view3(@Validated AddForm addForm,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		infoService.addUser(addForm);
		
		return "redirect:/start";
	}
	

}
