package com.example.EmployeeService.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiResponseDTO {
    EmployeeDTO employeeDTO;
    DepartmentDTO departmentDTO;
}
