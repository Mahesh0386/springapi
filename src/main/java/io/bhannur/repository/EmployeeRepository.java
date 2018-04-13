package io.bhannur.repository;

import io.bhannur.entity.Employee;

import java.util.List;



public interface EmployeeRepository {
    public List<Employee> findAll();
    public Employee findOne(String id);
    public Employee create(Employee emp);
    // public Employee update(String id, Employee emp);
    public Employee update(Employee emp); // for update we need total employee object
    public void delete(Employee id);
    public  Employee findByEmail(String email);
}
