package com.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public record EmployeeDto(
    String empName,
    double empSalary,
    String empAddress,
    @JsonFormat(pattern = "dd-MM-yyyy") Date empDOB,
    int deptId) {

}
