package com.cs4471.cspsp.service;

import com.cs4471.cspsp.util.dto.ServiceRegistrationRequest;
import com.cs4471.cspsp.util.dto.ServiceRegistrationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value = "cspsp-service-registry",
        url = "https://service-registry-backend.19ixenk8r62s.us-east.codeengine.appdomain.cloud")
public interface RegisterServiceHandler {
    @GetMapping("/api/service-registry/service/find-all")
    List<ServiceRegistrationResponse> getServicesFromRegistry();

    @PostMapping("/api/service-registry")
    void registerService(@RequestBody ServiceRegistrationRequest request);
}
