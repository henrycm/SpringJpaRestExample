package com.jhcm.rest.backend.validators;

import java.awt.TrayIcon.MessageType;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerValidationHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO processValidationError(ConstraintViolationException ex) {
		return processFieldError(ex.getConstraintViolations());
	}

	private MessageDTO processFieldError(Set<ConstraintViolation<?>> errors) {
		MessageDTO message = null;
		if (errors != null) {
			String msg = errors.toString();
			message = new MessageDTO(MessageType.ERROR, msg);
		}
		return message;
	}
}
