package com.demo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.model.Task;

public class TaskValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Task.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Task task = (Task) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.required", new Object[]{"Task name"});
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "error.required", new Object[]{"user select"});

	}

}
