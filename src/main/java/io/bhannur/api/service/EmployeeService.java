package io.bhannur.api.service;

import io.bhannur.api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findOne(String id);

    public Employee create(Employee emp);

    public Employee update(String id, Employee emp);

    public void delete(String id);
}

