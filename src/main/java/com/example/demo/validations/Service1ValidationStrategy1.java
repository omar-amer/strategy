package com.example.demo.validations;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.stereotype.Component;

import com.example.demo.services.ServiceRequest;

@Component
public class Service1ValidationStrategy1  extends RouteValidationStrategy{

	@Override
	public void validate(ServiceRequest serviceRequest) throws InvalidAttributesException 
	{
		if(!serviceRequest.getOperation().equals("invoke"))
			throw new InvalidAttributesException();
	}

}
