package com.omeracar.employee_external_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeClient {

    @Value("${vault.service.url}")
    private String vaultServiceUrl;

    @Value("${bearer.token}")
    private String bearerToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public Object getAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + bearerToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange(
                vaultServiceUrl + "/api/employees",
                HttpMethod.GET,
                entity,
                Object.class
        );

        return response.getBody();
    }
}