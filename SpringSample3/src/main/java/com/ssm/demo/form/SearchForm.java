package com.ssm.demo.form;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchForm implements Serializable{
	
	private String userId; 
	private String userName;
	
	private String userGender;

}
