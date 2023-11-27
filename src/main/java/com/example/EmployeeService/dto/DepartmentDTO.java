package com.example.EmployeeService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;
    @JsonProperty("department_name")
    private String departmentName;
    @JsonProperty("department_description")
    private String departmentDescription;
    @JsonProperty("department_code")
    private String departmentCode;

}
