package com.example.department.model;

import java.util.ArrayList;
import java.util.List;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {

  private Long id;
  private String name;
  private List<Employee> employees;

}
