package com.example.department.controller;


import com.example.department.client.EmployeeClient;
import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;
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
@RequestMapping("/department")
@Slf4j
public class DepartmentController {


  @Autowired
  private DepartmentRepository repository;

  @Autowired
  private EmployeeClient employeeClient;

  @PostMapping
  public Department add(@RequestBody Department department) {
    log.info("Department add: {}", department);
    return repository.addDepartment(department);
  }

  @GetMapping
  public List<Department> findAll() {
    log.info("Department find");
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Department findById(@PathVariable Long id) {
    log.info("Department find: id={}", id);
    return repository.findById(id);
  }

  @GetMapping("/with-employees")
  public List<Department> findAllWithEmployees() {
    log.info("Department find");
    List<Department> departments = repository.findAll();
    departments.stream().forEach(department -> {
      if (department.getId()!=null) {
        department.setEmployees(
            employeeClient.findByDepartment(department.getId()));
      }
    });
    return departments;
  }
}
