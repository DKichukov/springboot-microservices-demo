package com.project.repository;

import com.project.model.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  //  /**
//   * Finds an EmployeeDto by its employee ID.
//   * This query directly constructs an EmployeeDto from the Employee entity fields.
//   *
//   * @param empId The ID of the employee to find.
//   * @return An Optional containing the EmployeeDto if found, otherwise empty.
//   */
//  @Query("""
//      SELECT NEW com.project.dto.EmployeeDto(e.empName, e.empSalary, e.empAddress, e.empDOB, e.deptId)
//      FROM Employee e
//      WHERE e.id = :empId
//      """)
//  Optional<EmployeeDto> findByEmpId(int empId);
  Optional<Employee> findById(int empId);
}
