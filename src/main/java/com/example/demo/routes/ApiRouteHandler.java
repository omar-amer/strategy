package com.example.demo.routes;

import com.example.demo.services.ServiceResponse;
import com.example.demo.threading.CurrentRequest;
import com.example.demo.validations.RouteValidationStrategy;

@FunctionalInterface
public interface ApiRouteHandler {
    ServiceResponse handleRequest(CurrentRequest currentRequest);
}
