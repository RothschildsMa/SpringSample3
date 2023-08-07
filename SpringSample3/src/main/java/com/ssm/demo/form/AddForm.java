package com.ssm.demo.form;

import java.io.Serializable;

import com.ssm.demo.validator.DateRange;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddForm implements Serializable{
	
	private String userId;
	
	@NotBlank(message = "※名前を入力してください")
	@Size(max=20,message = "20文字以内で入力してください")
	@Pattern(regexp = "^[\u4E00-\u9FFF]+$", message = "漢字のみ入力してください")
	private String userName;
	
	@NotBlank(message = "※性別を選択してください")
	private String userGender;
	
	@NotBlank(message = "※生年月日を入力してください")
	@DateRange(startDate = "1950-01-01",endDate = "2023-07-28")
	private String userBirth;
	
	
	private String password;
	
	@NotBlank(message = "※電話番号を入力してください")
	@Pattern(regexp = "^0\\d{9,10}$", message = "正しい電話番号を入力してください。")
	private String userPhone;
	
	@NotBlank(message = "※メールアドレスを入力してください")
	@Email(message = "※有効なメールアドレスを入力してください")
	private String userMail;
}
