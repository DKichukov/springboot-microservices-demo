package com.project.service.impl;

import com.project.dto.DepartmentDto;
import com.project.model.Department;
import com.project.repository.DepartmentRepository;
import com.project.service.DepartmentService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  @Transactional
  public Department save(DepartmentDto departmentDto) {
    Department department = new Department();
    department.setDeptName(departmentDto.deptName());
    department.setDeptCode(departmentDto.deptCode());
    return departmentRepository.save(department);
  }

  @Override
  public Optional<DepartmentDto> findById(int deptId) {
    return departmentRepository.findDepartmentDtoById(deptId);
  }

}
