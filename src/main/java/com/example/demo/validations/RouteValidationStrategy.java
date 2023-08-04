package com.example.demo.validations;

import javax.naming.directory.InvalidAttributesException;

import com.example.demo.services.ServiceRequest;

public abstract class RouteValidationStrategy {
	
	public abstract void validate(ServiceRequest serviceRequest) throws InvalidAttributesException;

}
