package com.cs4471.cspsp.util.dto;

import lombok.Data;

@Data
public class ServiceRegistrationResponse {

    protected Integer service_id;
    protected Integer service_provider_id;
    protected Integer status;
    protected String endpoint_type;
    protected String endpoint_url;
}