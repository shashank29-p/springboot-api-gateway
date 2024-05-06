package com.example.employee.repository;

import com.example.employee.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

  private List<Employee> employees = new ArrayList<>();

  public Employee add(Employee employee) {
    employees.add(employee);
    return employee;
  }

  public Employee findById(Long id) {
    return employees.stream()
        .filter(a -> a.getId().equals(id))
        .findFirst()
        .orElseThrow();
  }

  public List<Employee> findAll() {
    return employees;
  }

  public List<Employee> findByDepartment(Long departmentId) {
    if(departmentId!=null) {
      return employees.stream()
          .filter(a -> a.getDepartmentId().equals(departmentId))
          .toList();
    }
    return new ArrayList<>();
  }
}
