package com.ssm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.demo.dao.InfoMapper;
import com.ssm.demo.entity.User;
import com.ssm.demo.form.AddForm;
import com.ssm.demo.form.SearchForm;

@Service
public class InfoService {
	
	//DI依存性注入
	@Autowired
	private InfoMapper mapper;
	
	public List<User> getAllUser() {
		return mapper.findall();
	}
	
	public List<User> searhUser(SearchForm searchForm){
		return mapper.findUsers(searchForm);
	}
	
	public void addUser(AddForm addForm) {
		User maxIdUser = mapper.findMaxUserId();
		String newNumber = maxIdUser.getUserId().substring(3);
		Number userId = Number.class.cast(Integer.parseInt(newNumber) + 1);
		String userIdstr = "0000" + userId.toString();
		String userNewId = userIdstr.substring(userIdstr.length() - 4);
		addForm.setUserId("nts" + userNewId);
		
		addForm.setPassword("a123");
		
		mapper.insert(addForm);
	}
	

}
