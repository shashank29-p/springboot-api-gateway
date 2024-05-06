package com.example.department.client;

import com.example.department.model.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EmployeeClient {

  @GetExchange("/employee/department/{departmentId}")
  public List<Employee> findByDepartment(@PathVariable Long departmentId);

}
