package com.jhcm.rest.backend.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("IN VALIDATOR");
//		errors.reject("DIE");
	}
}