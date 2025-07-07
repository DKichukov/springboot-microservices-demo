package com.project.service;

import com.project.dto.DepartmentDto;
import com.project.model.Department;
import java.util.Optional;

public interface DepartmentService {

  Department save(DepartmentDto departmentDto);

  Optional<DepartmentDto> findById(int deptId);

}

