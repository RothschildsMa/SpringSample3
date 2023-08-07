package com.ssm.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssm.demo.entity.User;
import com.ssm.demo.form.AddForm;
import com.ssm.demo.form.SearchForm;

@Mapper
public interface InfoMapper {
	
	List<User> findall();
	
	List<User> findUsers(SearchForm searchForm);
	
	User findMaxUserId();
	
	void insert(AddForm addForm);

}
