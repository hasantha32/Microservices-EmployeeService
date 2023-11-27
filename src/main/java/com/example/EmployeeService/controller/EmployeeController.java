package com.example.EmployeeService.controller;

import com.example.EmployeeService.dto.ApiResponseDTO;
import com.example.EmployeeService.dto.EmployeeDTO;
import com.example.EmployeeService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(saveEmployee , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable Long id){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployee(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
