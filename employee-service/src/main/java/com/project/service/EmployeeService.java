package com.project.service;

import com.project.dto.EmployeeDto;
import com.project.model.Employee;
import com.project.vo.RestTemplateVO;

public interface EmployeeService {

  Employee save(EmployeeDto employeeDto);

  RestTemplateVO findById(int empId);

}
