package com.omeracar.employee_external_service.controller;
import com.omeracar.employee_external_service.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external/employees")
@RequiredArgsConstructor
public class ExternalEmployeeController {

    private final EmployeeClient employeeClient;

    @GetMapping
    public Object getAllEmployees() {
        return employeeClient.getAllEmployees();
    }
}