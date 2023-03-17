package com.rouvsen.business.services.impl;

import com.rouvsen.business.dto.EmployeeDto;
import com.rouvsen.business.services.inter.EmployeeService;
import com.rouvsen.data.entity.EmployeeEntity;
import com.rouvsen.data.repository.EmployeeRepository;
import com.rouvsen.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //List
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entityList = employeeRepository.findAll();
        for (EmployeeEntity entity: entityList) {
            EmployeeDto employeeDto = EntityToDto(entity);
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //SAVE
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //FIND
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee "+id+" numaralı product id bulunamadı !!!!") );
        EmployeeDto employeeDto = EntityToDto(employee);
        return ResponseEntity.ok(employeeDto);
    }

    //UPDATE
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(Long id,EmployeeDto employeeDetails){
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);

        EmployeeDto employeeDto = EntityToDto(updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //DELETE
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //Model Mapper
    //Entity ==> DTO
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //DTO ==> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
