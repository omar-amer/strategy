package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.threading.CurrentRequest;

@Service
public abstract class AbstractBaseService 
{
	@Autowired protected CurrentRequest currentRequest;
	
	ServiceRequest getRequest()
	{
		return this.currentRequest.getCurrentRequest();
	}
}
