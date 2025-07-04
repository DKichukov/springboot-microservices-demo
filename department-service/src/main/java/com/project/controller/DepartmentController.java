package com.project.controller;

import com.project.dto.DepartmentDto;
import com.project.model.Department;
import com.project.service.DepartmentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  private final DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @PostMapping("/save")
  public ResponseEntity<Department> save(@RequestBody DepartmentDto departmentDto){
    return ResponseEntity.ok(departmentService.save(departmentDto));
  }

  @GetMapping("/findbyid/{deptId}")
  public ResponseEntity<Optional<DepartmentDto>> findById(@PathVariable int deptId){
    return ResponseEntity.ok(departmentService.findById(deptId));
  }
}
