package com.cs4471.cspsp.util.dto;

import lombok.Data;

@Data
public class ServiceRegistrationRequest {

    protected Integer service_provider_id;
    protected String endpoint_type;
    protected String endpoint_url;
    protected Integer status;
}