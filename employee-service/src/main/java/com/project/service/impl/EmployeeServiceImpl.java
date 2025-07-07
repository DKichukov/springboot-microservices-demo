package com.project.service.impl;

import com.project.dto.EmployeeDto;
import com.project.model.Employee;
import com.project.repository.EmployeeRepository;
import com.project.service.EmployeeService;
import com.project.vo.Department;
import com.project.vo.RestTemplateVO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final RestTemplate restTemplate;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
    this.employeeRepository = employeeRepository;
    this.restTemplate = restTemplate;
  }
@Override
public Employee save(EmployeeDto employeeDto) {

    Employee employee = new Employee();
    employee.setEmpName(employeeDto.empName());
    employee.setEmpSalary(employeeDto.empSalary());
    employee.setEmpAddress(employeeDto.empAddress());
    employee.setEmpDOB(employeeDto.empDOB());
    employee.setDeptId(employeeDto.deptId());

    return employeeRepository.save(employee);

  }
@Override
public RestTemplateVO findById(int empId) {

    RestTemplateVO restTemplateVO = new RestTemplateVO();

      var employee = employeeRepository.findById(empId).orElse(new Employee());

    restTemplateVO.setEmployee(employee);

    // Service Communication
    Department department = restTemplate.getForObject("http://department-service/api/departments/findbyid/" + employee.getDeptId(), Department.class);

    restTemplateVO.setDepartment(department);

    return restTemplateVO;
  }


}
