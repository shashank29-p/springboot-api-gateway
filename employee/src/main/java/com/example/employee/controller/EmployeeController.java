package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {


  @Autowired
  EmployeeRepository repository;

  @PostMapping
  public Employee add(@RequestBody Employee employee) {
    log.info("Employee add: {}", employee);
    return repository.add(employee);
  }

  @GetMapping
  public List<Employee> findAll() {
    log.info("Employee find");
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Employee findById(@PathVariable Long id) {
    log.info("Employee find: id={}", id);
    return repository.findById(id);
  }

  @GetMapping("/department/{departmentId}")
  public List<Employee> findByDepartment(@PathVariable Long departmentId) {
    log.info("Employee find: departmentId={}", departmentId);
    return repository.findByDepartment(departmentId);
  }

}
