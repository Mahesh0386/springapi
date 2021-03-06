package io.bhannur.api.service;

import io.bhannur.api.entity.Employee;
import io.bhannur.api.exception.BadRequestException;
import io.bhannur.api.exception.EntityNotFoundException;
import io.bhannur.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(String id) {
        Employee emp = repository.findOne(id);
        if (emp == null) {
            throw new EntityNotFoundException("Employee not found");
        }
        return emp;
    }

    @Override
    @Transactional
    public Employee create(Employee emp) {
        Employee existing = repository.findByEmail(emp.getEmail());
        if (existing != null) {
            throw new BadRequestException("Employee with this email already exists");
        }
        return repository.create(emp);
    }

    @Override
    @Transactional
    public Employee update(String id, Employee emp) {
        Employee existing = repository.findOne(id);
        if (existing == null) {
            throw new EntityNotFoundException("Employee not found");
        }
        return repository.update(emp);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Employee existing = repository.findOne(id);
        if (existing == null) {
            throw new EntityNotFoundException("Employee not found");
        }
        repository.delete(existing);
    }
}