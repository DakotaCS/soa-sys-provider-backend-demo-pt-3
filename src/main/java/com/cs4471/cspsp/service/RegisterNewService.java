package com.cs4471.cspsp.service;

import com.cs4471.cspsp.util.dto.ServiceRegistrationRequest;
import com.cs4471.cspsp.util.dto.ServiceRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegisterNewService {

    @Autowired
    RegisterServiceHandler registerServiceHandler;

    private final String BASE_PROVIDER_URL = "https://service-provider.19ixenk8r62s.us-east.codeengine.appdomain.cloud/api";
    public void registerNewService(Integer serviceProviderId, String endpointType,
                                   String endpointURL) {
        List<ServiceRegistrationResponse> currentServiceList =
                registerServiceHandler.getServicesFromRegistry();

        boolean shouldInsert = currentServiceList.stream()
                .noneMatch(response ->
                        response.getService_provider_id().equals(serviceProviderId) &&
                                response.getEndpoint_type().equals(endpointType) &&
                                response.getEndpoint_url().equals(BASE_PROVIDER_URL+endpointURL));

        if (shouldInsert) {
            ServiceRegistrationRequest request = new ServiceRegistrationRequest();
            request.setService_provider_id(serviceProviderId);
            request.setEndpoint_type(endpointType);
            request.setStatus(1);
            request.setEndpoint_url(BASE_PROVIDER_URL + endpointURL);
            System.out.println("New Service Registered: " + BASE_PROVIDER_URL + endpointURL);
            registerServiceHandler.registerService(request);
        }
        else if (!shouldInsert) {
            System.out.println("The Service being evaluated has already been registered. No Action Required.");
        }
    }
}