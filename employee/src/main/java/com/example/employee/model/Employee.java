package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

  private Long id;
  private Long departmentId;
  private String name;
  private int age;
  private String position;

}
