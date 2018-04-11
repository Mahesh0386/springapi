package io.bhannur.service;

import io.bhannur.entity.Employee;
import io.bhannur.exception.BadRequestException;
import io.bhannur.exception.EntityNotFoundException;
import io.bhannur.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findOne(String id) {
        Employee emp = repository.findOne(id);
                if(emp == null)
                {
                    throw new EntityNotFoundException(("Employee not found!"));
                }
       return emp;
    }

    @Override
    public Employee create(Employee emp) {
        Employee existingEmail = repository.findByEmail(emp.getEmail());
        if(existingEmail != null)
        {
            throw new BadRequestException(("Employee already exist with the given email!"));
        }
        return repository.create(emp);
    }

    @Override
    public Employee update(String id, Employee emp) {
        Employee existing = repository.findOne(id);
        if(existing == null)
        {
            throw new EntityNotFoundException(("Employee not found!"));
        }
        return repository.update(id,emp);
    }

    @Override
    public void delete(String id) {
        Employee emp = repository.findOne(id);
        if(emp == null)
        {
            throw new EntityNotFoundException(("Employee not found!"));
        }
        repository.delete(id);
    }
}
