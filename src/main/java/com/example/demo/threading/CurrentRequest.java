package com.example.demo.threading;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode; 
import org.springframework.stereotype.Component;

import com.example.demo.services.ServiceRequest;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentRequest {
    private ServiceRequest serviceRequest;
    private String token;
    private String language;
    private String signature;

    public ServiceRequest getCurrentRequest() {
        return serviceRequest;
    }

    public void setCurrentRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
    
}