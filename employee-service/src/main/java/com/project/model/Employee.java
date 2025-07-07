package com.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String empName;

  private double empSalary;

  private String empAddress;

  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date empDOB;

  private int deptId;
}
