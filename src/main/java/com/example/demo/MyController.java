package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.routes.Router;
import com.example.demo.services.ServiceRequest;
import com.example.demo.services.ServiceResponse;
import com.example.demo.threading.CurrentRequest;


@RestController
public class MyController {
    @Autowired Router router;
	@Autowired protected CurrentRequest currentRequest;
    @PostMapping("/api/v1/resource/{operation}")
    public ResponseEntity<Map<String,ServiceResponse>> handlePostRequest(
    		@RequestHeader(required = false) String token,
    		@RequestHeader(required = false) String language,
    		@RequestHeader(required = false) String signature,
    		@PathVariable String operation, @RequestBody ServiceRequest requestBody) 
    	{
        currentRequest.setCurrentRequest(requestBody);
        currentRequest.setLanguage(language);
        currentRequest.setToken(token);
        currentRequest.setSignature(signature);
        
        Map<String, ServiceResponse> body = new HashMap<>();
        body.put("message", router.getHandlerForRoute(operation).handleRequest(currentRequest));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
