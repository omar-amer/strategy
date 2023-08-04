package com.example.demo.routes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.services.Service1;
import com.example.demo.services.Service2;
import com.example.demo.services.ServiceResponse;
import com.example.demo.threading.CurrentRequest;
import com.example.demo.validations.RouteValidationStrategy;
@Component
public class Router {
	@Autowired Service1 service1;
	@Autowired Service2 service2;

	 private final Map<String, ApiRouteHandler> routeMap;

	    public Router() 
	    {
	    	  routeMap = new ConcurrentHashMap<>();	    	  
	    	  routeMap.put("path1", (currentRequest) -> {return this.validateThenRoute(service1.executeServiceLogic(currentRequest), service1.service1ValidationStrategy1, currentRequest);});
	    	  routeMap.put("path2", (currentRequest) -> {return this.validateThenRoute(service1.executeServiceLogic2(currentRequest), service1.service1ValidationStrategy2, currentRequest);});
	    	  routeMap.put("service12", (currentRequest) -> {return this.validateThenRoute(service2.executeServiceLogic(currentRequest), service2.service2ValidationStrategy1, currentRequest);});
	    	  routeMap.put("service22", (currentRequest) -> {return this.validateThenRoute(service2.executeServiceLogic2(currentRequest), service2.service2ValidationStrategy2, currentRequest);});
	    }

	    public ApiRouteHandler getHandlerForRoute(String route) 
	    {
	        return routeMap.get(route);
	    }
	    
	    ServiceResponse validateThenRoute(ServiceResponse serviceResponse, RouteValidationStrategy routeValidationStrategy,CurrentRequest currentRequest)
	    {
	    	try 
	    	{
				routeValidationStrategy.validate(currentRequest.getCurrentRequest());
			} 
	    	catch (InvalidAttributesException exception) 
	    	{
				serviceResponse.setResult("1");
				exception.printStackTrace();
			}
			return serviceResponse;
	    	
	    }
	  
}
