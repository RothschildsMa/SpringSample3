package com.ssm.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	private String userId;
	private String userName;
	private String userGender;
	private String userBirth;
	private String userPhone;
	private String userMail;

}
