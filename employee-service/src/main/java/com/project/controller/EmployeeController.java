package com.project.controller;

import com.project.dto.EmployeeDto;
import com.project.model.Employee;
import com.project.service.EmployeeService;
import com.project.vo.RestTemplateVO;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping("/save")
  public ResponseEntity<Employee> save(@RequestBody EmployeeDto employeeDto){
    return ResponseEntity.ok(employeeService.save(employeeDto));
  }

  @GetMapping("/findbyid/{empId}")
  public ResponseEntity<RestTemplateVO> findById(
      @Parameter(
          description = "ID of the employee to retrieve",
          required = true,
          example = "1"
      )
      @PathVariable int empId) {
    return ResponseEntity.ok(employeeService.findById(empId));
  }
}
