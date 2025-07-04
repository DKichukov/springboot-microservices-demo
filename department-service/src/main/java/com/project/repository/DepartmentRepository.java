package com.project.repository;

import com.project.dto.DepartmentDto;
import com.project.model.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  /**
   * Finds a DepartmentDto by its ID.
   * This query directly constructs a DepartmentDto from the Department entity fields.
   *
   * @param deptId The ID of the department to find.
   * @return An Optional containing the DepartmentDto if found, otherwise empty.
   */
  @Query("""
    SELECT NEW com.project.dto.DepartmentDto(d.deptName, d.deptCode)
    FROM Department d
    WHERE d.id = :deptId
  """)
  Optional<DepartmentDto> findDepartmentDtoById(int deptId);

}
