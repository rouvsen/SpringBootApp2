package com.rouvsen.business.services.inter;

import com.rouvsen.business.dto.EmployeeDto;
import com.rouvsen.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //CRUD
    List<EmployeeDto> getAllEmployees();
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;
    ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;
    ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) throws Throwable;

    //Model Mapper
    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}
