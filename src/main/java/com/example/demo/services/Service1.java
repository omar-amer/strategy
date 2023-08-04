package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.threading.CurrentRequest;
import com.example.demo.validations.Service1ValidationStrategy1;
import com.example.demo.validations.Service1ValidationStrategy2;

@Service
public class Service1 extends AbstractBaseService {

	@Autowired public Service1ValidationStrategy1 service1ValidationStrategy1;
	
	@Autowired public Service1ValidationStrategy2 service1ValidationStrategy2;
	
	public ServiceResponse executeServiceLogic(CurrentRequest currentRequest) 
	{
		ServiceResponse serviceResponse=new ServiceResponse();
		ServiceRequest serviceRequest=currentRequest.getCurrentRequest();
		serviceResponse.setResult(serviceRequest.getOperation());
		return serviceResponse;
	}
	public ServiceResponse executeServiceLogic2(CurrentRequest currentRequest) 
	{
		ServiceResponse serviceResponse=new ServiceResponse();
		ServiceRequest serviceRequest=currentRequest.getCurrentRequest();

		serviceResponse.setResult(serviceRequest.getOperation()+"2");
		return serviceResponse;
	}

}
