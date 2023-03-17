package com.rouvsen.business.services.inter;

import com.rouvsen.business.dto.EmployeeDto;
import com.rouvsen.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //CRUD
    List<EmployeeDto> getAllEmployees();
    ResponseEntity<EmployeeDto> getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);
    ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id);

    //Model Mapper
    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}
