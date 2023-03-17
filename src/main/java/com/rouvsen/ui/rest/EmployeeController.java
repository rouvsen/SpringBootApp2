package com.rouvsen.ui.rest;

import com.rouvsen.business.dto.EmployeeDto;
import com.rouvsen.business.services.inter.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //ROOT
    @GetMapping({"/index", "/"})
    public String getRoot(){
        return "index";
    }

    //LIST
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    //FIND
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        ResponseEntity<EmployeeDto> employee = employeeService.getEmployeeById(id);
        return employee;
    }

    //CREATE
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto);
        return employeeDto;
    }

    //UPDATE
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        ResponseEntity<EmployeeDto> updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee.getBody());
    }

    //DELETE
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        ResponseEntity<Map<String, Boolean>> response = employeeService.deleteEmployee(id);
        Boolean isDeleted = response.getBody().get("deleted");
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted", isDeleted);
        return ResponseEntity.ok(map);
    }
}
