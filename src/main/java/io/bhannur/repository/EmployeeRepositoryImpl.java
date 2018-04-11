package io.bhannur.repository;

import io.bhannur.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findOne(String id) {
        return null;
    }

    @Override
    public Employee create(Employee emp) {
        return null;
    }

    @Override
    public Employee update(String id, Employee emp) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }
}
