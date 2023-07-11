package com.example.be.service;

import com.example.be.entity.Employee;
import com.example.be.request.EmployeeRequest;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    HashMap<String, Object> add(EmployeeRequest employee);

    HashMap<String, Object> update(EmployeeRequest employee, Long id);

    HashMap<String, Object> remove(Long id);

}
