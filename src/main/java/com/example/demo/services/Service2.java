package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.threading.CurrentRequest;
import com.example.demo.validations.Service2ValidationStrategy1;
import com.example.demo.validations.Service2ValidationStrategy2;

@Service
public class Service2 extends AbstractBaseService {

	@Autowired public Service2ValidationStrategy1 service2ValidationStrategy1;
	
	@Autowired public Service2ValidationStrategy2 service2ValidationStrategy2;
	
	public ServiceResponse executeServiceLogic(CurrentRequest currentRequest) 
	{
		ServiceResponse serviceResponse=new ServiceResponse();
		ServiceRequest serviceRequest=currentRequest.getCurrentRequest();

		serviceResponse.setResult(serviceRequest.getOperation()+"3");
		return serviceResponse;
	}
	public ServiceResponse executeServiceLogic2(CurrentRequest currentRequest) 
	{
		ServiceResponse serviceResponse=new ServiceResponse();
		ServiceRequest serviceRequest=currentRequest.getCurrentRequest();

		serviceResponse.setResult(serviceRequest.getOperation()+"4");
		return serviceResponse;
	}

}
