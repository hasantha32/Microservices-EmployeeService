package com.example.EmployeeService.service.impl;

import com.example.EmployeeService.dto.ApiResponseDTO;
import com.example.EmployeeService.dto.DepartmentDTO;
import com.example.EmployeeService.dto.EmployeeDTO;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.repository.EmployeeRepository;
import com.example.EmployeeService.service.APIClient;
import com.example.EmployeeService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .departmentCode(employeeDTO.getDepartmentCode())
                .build();
        Employee employee1 = employeeRepository.save(employee);

        EmployeeDTO employeeDto =EmployeeDTO.builder()
                .id(employee1.getId())
                .firstName(employee1.getFirstName())
                .lastName(employee1.getLastName())
                .email(employee1.getEmail())
                .departmentCode(employee1.getDepartmentCode())
                .build();
        return employeeDto;

    }

    @Override
    public ApiResponseDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        //COMMUNICATION USING REST TEMPLATE
//       ResponseEntity<DepartmentDTO> response = restTemplate.
//               getForEntity("http://localhost:8090/api/departments/" + employee.getDepartmentCode(),
//               DepartmentDTO.class);
//               DepartmentDTO departmentDTO = response.getBody();

           //    COMMUNICATION USING WEB CLIENT
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8090/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        //COMMUNICATION USING OPEN FEIGN(feign client)
DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDTO employeeDTO= EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode())
                .build();

        ApiResponseDTO apiResponseDTO = ApiResponseDTO.builder()
                .employeeDTO(employeeDTO)
                .departmentDTO(departmentDTO)
                .build();

        return apiResponseDTO;

    }
}
