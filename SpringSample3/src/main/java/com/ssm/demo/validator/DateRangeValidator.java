package com.ssm.demo.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, String>{

	private LocalDate startDate;
	
	private LocalDate endDate;
	


	@Override
	public void initialize(DateRange dateRange) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			startDate = LocalDate.parse(dateRange.startDate(),formatter);
			endDate = LocalDate.parse(dateRange.endDate(),formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("フォーマット変換失敗、yyyy-MM-ddにしてください",e);
		}
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.isEmpty()) {
			return true;
		}
		
		LocalDate date;
		
		try {
			date = LocalDate.parse(value,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception e) {
			return false;
		}
		
		return date.isEqual(startDate) || date.isEqual(endDate) 
				|| (date.isAfter(startDate) && date.isBefore(endDate));
		
	}

}
