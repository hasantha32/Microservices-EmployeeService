package com.example.EmployeeService.service;

import com.example.EmployeeService.dto.ApiResponseDTO;
import com.example.EmployeeService.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployee(Long id);
}
